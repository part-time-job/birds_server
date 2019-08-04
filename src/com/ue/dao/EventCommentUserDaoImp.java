package com.ue.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ue.domain.Comment;
import com.ue.domain.Event;
import com.ue.domain.EventCommentUser;
import com.ue.domain.User;
import com.ue.service.CommentService;
import com.ue.service.EventService;
import com.ue.service.UserService;
import com.ue.utils.BeanUtils;

public class EventCommentUserDaoImp implements EventCommentUserDao {

	EventService eventService;
	CommentService commentService;
	UserService userService;
	private JdbcTemplate template = (JdbcTemplate) BeanUtils.getBean("jdbcTemplate"); 
	
	public JdbcTemplate getTemplate() {  
        return template;  
    } 
	
	public void setTemplate(JdbcTemplate template) {  
        this.template = template;  
    }
	
	public EventCommentUserDaoImp() {
		eventService = (EventService) BeanUtils.getBean("eventService");
		commentService = (CommentService) BeanUtils.getBean("commentService");
		userService = (UserService) BeanUtils.getBean("userService");
	}

	/* (non-Javadoc)
	 * @see com.ue.dao.EventCommentUserDao#getViewByEventId(int)
	 */
	@Override
	public EventCommentUser getViewByEventId(int event_id) {
		Event event = eventService.searchEventByEventId(event_id);
		User user = userService.searchUserByUserId(event.getUse_id());
		List<Comment> comments = commentService.getCommentsByEventId(event_id);
		return new EventCommentUser(user, event, comments);
	}
	@Override
	public long countBirds(){
		String sql = "select sum(eve_count) as count from tb_event";
		@SuppressWarnings("unchecked")
		List<Integer> count = this.template.query(sql, new countBirds());
		if(count==null)
			return 0;
		return count.get(0);
		
	}
	
	class countBirds implements RowMapper {  
        public Object mapRow(ResultSet rs, int index) throws SQLException {
        	return rs.getInt("count");
        }  
    }
}
