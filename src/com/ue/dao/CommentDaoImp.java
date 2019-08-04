package com.ue.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ue.domain.Comment;

public class CommentDaoImp implements CommentDao {
	private JdbcTemplate template; 
	private final String INSERT = "insert into tb_comment(eve_id, use_id, com_content, com_answer, com_time, com_positivecount, com_negativecount) values(?,?,?,?,?,?,?)";  
	private final String DELETE_BY_COMMENT_ID = "delete from tb_comment where com_id=?";  
	private final String UPDATE_BY_COMMENT_ID = "update tb_comment set eve_id=?,use_id=?,com_content=?,com_answer=?, com_time=?, com_positivecount=?, com_negativecount=?) where com_id=?";  
	private final String SEARCH_BY_COMMENT_ID = "select * from tb_comment where eve_id=?"; 
	private final String SEARCH_BY_EVENT_ID = "select * from tb_comment where eve_id=?";
	private final String GETPAGENUM = "select count(*) as page_num from tb_comment where eve_datatype=?";
	
	/* (non-Javadoc)
	 * @see com.ue.dao.CommentDao#getTemplate()
	 */
	@Override
	public JdbcTemplate getTemplate() {  
        return template;  
    }  
  
    /* (non-Javadoc)
	 * @see com.ue.dao.CommentDao#setTemplate(org.springframework.jdbc.core.JdbcTemplate)
	 */
    @Override
	public void setTemplate(JdbcTemplate template) {  
        this.template = template;  
    }

	/* (non-Javadoc)
	 * @see com.ue.dao.CommentDao#insertComment(com.ue.domain.Comment)
	 */
	@Override
	public boolean insertComment(Comment comment) {
		// TODO Auto-generated method stub
		int res = this.template.update(INSERT, comment.getEve_id(),comment.getUse_id(),comment.getCom_content(),comment.getCom_answer(),comment.getCom_time(),comment.getCom_positivecount(),comment.getCom_negativecount());  
		return res > 0;
	}

	/* (non-Javadoc)
	 * @see com.ue.dao.CommentDao#deleteCommentByCommentId(int)
	 */
	@Override
	public boolean deleteCommentByCommentId(int commentId) {
		// TODO Auto-generated method stub
		int res = this.template.update(DELETE_BY_COMMENT_ID, commentId);
		return res > 0;
	}

	/* (non-Javadoc)
	 * @see com.ue.dao.CommentDao#updateCommentByCommentId(com.ue.domain.Comment)
	 */
	@Override
	public boolean updateCommentByCommentId(Comment comment) {
		// TODO Auto-generated method stub
		int res = this.template.update(UPDATE_BY_COMMENT_ID, comment.getEve_id(),comment.getUse_id(),comment.getCom_content(),comment.getCom_answer(),comment.getCom_time(),comment.getCom_positivecount(),comment.getCom_negativecount(), comment.getCom_id());
		return res > 0;
	}

	/* (non-Javadoc)
	 * @see com.ue.dao.CommentDao#searchCommentByCommentId(int)
	 */
	@Override
	public Comment searchCommentByCommentId(int commentId) {
		// TODO Auto-generated method stub
		//Map<String,Object> map = this.template.queryForMap(SEARCH_BY_comment_ID,commentId);
		List<Comment> list = this.template.query(SEARCH_BY_COMMENT_ID,new Integer[]{commentId},new BeanPropertyRowMapper<Comment>(Comment.class));
		//comment comment = this.MapToObject(map);
		return list.get(0);
	}

	/* (non-Javadoc)
	 * @see com.ue.dao.CommentDao#searchcommentByEventId(int)
	 */
	@Override
	public List<Comment> searchCommentByEventId(int eventId) {
		// TODO Auto-generated method stub
		return (List<Comment>) template.query(SEARCH_BY_EVENT_ID,new Integer[]{eventId},new BeanPropertyRowMapper<Comment>(Comment.class));
	}

	/* (non-Javadoc)
	 * @see com.ue.dao.CommentDao#searchCommentByPage(int, int, int)
	 */
	@Override
	public List<Comment> searchCommentByPage(int pageNow, int pageSize, int eventId) {
		// TODO Auto-generated method stub
		String sql;
		int preCount = (pageNow-1)*pageSize;
		sql = "select * from tb_comment where eve_id="+eventId+ " limit ?,"+pageSize;
		return (List<Comment>) template.query(sql,new Integer[]{preCount},new BeanPropertyRowMapper<Comment>(Comment.class));
	}

	
	class PageNum implements RowMapper {  
        public Object mapRow(ResultSet rs, int index) throws SQLException {
        	return rs.getInt("page_num");
        }  
    }

	/* (non-Javadoc)
	 * @see com.ue.dao.CommentDao#getPageNum(int)
	 */
	@Override
	public int getPageNum(int dataType) {
		List<Integer> ii = this.template.query(GETPAGENUM, new Integer[]{dataType}, new PageNum());
		if(ii == null){
			return 0;
		}
		return ii.get(0);
	}
	@Override
	public long getCommentCount(){
		String sql = "select count(*) as commentCount from tb_comment";
		List<Integer> count = this.template.query(sql, new CommentCount());
		if(count==null)
			return 0;
		return count.get(0); 
	}
	class CommentCount implements RowMapper {  
        public Object mapRow(ResultSet rs, int index) throws SQLException {
        	return rs.getInt("commentCount");
        }  
    }
}
