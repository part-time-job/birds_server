package com.ue.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ue.dao.EventDaoImp.CountPageMapper;
import com.ue.domain.Comment;
import com.ue.domain.Event;
import com.ue.domain.User;
import com.ue.domain.User3;
import com.ue.utils.LogUtils;

public class EventDaoImp implements EventDao {

	private static final long serialVersionUID = 1L;

	// @Resource(name="dataSource")
	private JdbcTemplate template;
	private final String GETPAGENUM = "select count(*) as page_num from tb_event where eve_datatype=?";
	
	public static final String INSERT = "insert into User(name,sex) values(?,?)";

	public static final String DELETEBYID = "delete from User where id=?";
	public static final String DELETEBYNAME = "delete from User where name=?";

	public static final String UPDATEBYID = "update User set name=?,sex=? where id=?";
	public static final String UPDATEBYNAME = "update User set sex=? where name=?";

	public static final String SEARCHBYID = "select * from User where id=?";
	public static final String SEARCHBYNAME = "select * from User where name=?";
	public static final String GETALL = "select * from User";

	
	private final String DELETE_BY_EVENT_ID = "delete from tb_event where eve_id=?";  
	private final String UPDATE_BY_EVENT_ID = "update tb_event set use_id=?,eve_count=?,eve_positivecount=?,eve_question=?, eve_time=?, eve_longitude=?, eve_latitude=?, eve_datatype=?, eve_puretext=?, eve_audiourl=?, eve_pictureurl=?, eve_description=?, eve_remark=?  where eve_id=?";  
	private final String SEARCH_BY_EVENT_ID = "select * from tb_event where eve_id=?"; 
	private final String SEARCH_BY_USER_ID = "select * from tb_event where use_id=?";
	private final String AUDIOTOPLIST = "SELECT * FROM tb_event WHERE eve_datatype = 2  ORDER BY eve_positivecount DESC LIMIT 0, 10";
	
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ue.dao.PuretextDao#findEventsByUse_id_page(int, int, int)
	 */

	@Override
	public List<Event> findEventsByUse_id_page(int current_page, int use_id,  int eve_datatype, int page_length) {
		List<Event> list = new ArrayList<Event>();
	
		int eve_id_begin = (current_page - 1 ) * page_length + 1;
		String sql = "SELECT * FROM tb_event WHERE use_id = ? AND eve_datatype = ? ORDER BY eve_id DESC LIMIT ?,? ";
		LogUtils.sysoln(sql);
		Integer[] args = { use_id, eve_datatype, eve_id_begin, page_length };
		list = template.query(sql, args, new BeanPropertyRowMapper<Event>(Event.class));
		return list;
	}


	@Override
	public List<Event> findEventsByPage(int current_page, int eve_datatype, int page_length) {
		int page_count = countPage(eve_datatype,page_length);
		// 如果是最后一页
		if(current_page == -1 || current_page > page_count){
			current_page = page_count;
		}
		List<Event> list = new ArrayList<Event>();		
		int eve_id_begin = (current_page - 1 ) * page_length;
		String sql = "SELECT * FROM tb_event WHERE eve_datatype = ? ORDER BY eve_id DESC LIMIT ?,? ";
		LogUtils.sysoln(sql);
		Integer[] args = {eve_datatype, eve_id_begin, page_length };
		list = template.query(sql, args, new BeanPropertyRowMapper<Event>(Event.class));
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int countPage(int eve_datatype,int page_length) {
		String sql = "SELECT COUNT(*) AS count_result FROM tb_event WHERE eve_datatype = ?";
		LogUtils.sysoln(sql);
		Integer[] args = {eve_datatype};	
		List<Integer> list = (List<Integer>)template.query(sql, args, new CountPageMapper());
		if(list == null ){
			return 0;
		}
		int allRows = list.get(0);
		if(allRows / page_length * page_length == allRows){
			return allRows / page_length;
		}
		return allRows / page_length + 1;
	}
	

	@Override
	public boolean insertEvent(Event event) {		
		  
		String sql = "insert into tb_event ("
				+ "use_id, "
				+ "eve_count, "
				+ "eve_positivecount, "
				+ "eve_question, "
				+ "eve_time, "
				+ "eve_longitude, "
				+ "eve_latitude, "
				+ "eve_datatype, "
				+ "eve_puretext, "
				+ "eve_audiourl, "
				+ "eve_pictureurl, "
				+ "eve_description, "
				+ "eve_remark"
				+ ") values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		LogUtils.sysoln(sql);
		int res = this.template.update(sql,event.getUse_id(),event.getEve_count(),event.getEve_positivecount(),
				event.getEve_question(),event.getEve_time(),event.getEve_longitude(),
				event.getEve_latitude(),event.getEve_datatype(),event.getEve_puretext(),
				event.getEve_audiourl(),event.getEve_pictureurl(),event.getEve_description(),
				event.getEve_remark()				
				);
		return res > 0;
	}	

	public boolean deleteUserById(int tagId) {
		// TODO Auto-generated method stub
		int res = this.template.update(DELETEBYID, tagId);
		System.out.println("res:" + res);
		return res > 0;
	}

	public boolean deleteUserByName(String tagName) {
		int res = this.template.update(DELETEBYNAME, tagName);
		return res > 0;
	}

	public boolean updateUserById(int tagId, User3 newUser) {
		int res = this.template.update(UPDATEBYID, newUser.getName(), newUser.getSex(), tagId);
		return res > 0;
	}

	public boolean updateUserByName(String tagName, User3 newUser) {
		int res = this.template.update(UPDATEBYNAME, newUser.getSex(), tagName);
		return res > 0;
	}

	

	

	

	

	@SuppressWarnings("rawtypes")
	class UserRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			User3 user = new User3();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setSex(rs.getString("sex"));
			return user;
		}
	}
	class CountPageMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int index) throws SQLException {			
			return rs.getInt("count_result");
		}
	}
	@Override
	public List<Event> searchEventByPage(int pageNow, int pageSize, int dataType, boolean filterByUserId, int userId) {
		// TODO Auto-generated method stub
		String sql;
		int preCount = (pageNow-1)*pageSize;
		if(filterByUserId==false){
			sql = "select * from tb_event where eve_datatype="+dataType+" ORDER BY eve_id DESC limit ?,"+pageSize;
		}else{
			sql = "select * from tb_event where use_id="+userId+" and eve_datatype="+dataType+" ORDER BY eve_id DESC limit ?,"+pageSize;
		}
		return (List<Event>) template.query(sql,new Integer[]{preCount},new BeanPropertyRowMapper<Event>(Event.class));
	}

	@Override
	public Event searchEventByEventId(int eventId) {
		// TODO Auto-generated method stub
		Map<String,Object> map = this.template.queryForMap(SEARCH_BY_EVENT_ID,eventId);
		Event event = this.MapToObject(map);
		return event;
	}

	@Override
	public boolean updateEventByEventId(Event event) {
		// TODO Auto-generated method stub
		int res = this.template.update(UPDATE_BY_EVENT_ID, event.getUse_id(),event.getEve_count(),event.getEve_positivecount(),event.getEve_question(),event.getEve_time(),event.getEve_longitude(),event.getEve_latitude(),event.getEve_datatype(),event.getEve_puretext(),event.getEve_audiourl(),event.getEve_pictureurl(),event.getEve_description(),event.getEve_remark(),event.getEve_id());
		return res > 0;
	}

	@Override
	public List<Event> getAudioTopTen() {
		// TODO Auto-generated method stub
		return (List<Event>) template.query(AUDIOTOPLIST,new Integer[]{},new BeanPropertyRowMapper<Event>(Event.class));
	}
	class PageNum implements RowMapper {  
        public Object mapRow(ResultSet rs, int index) throws SQLException {
        	return rs.getInt("page_num");
        }  
    }

	@Override
	public int getPageNum(int dataType) {
		List<Integer> ii = this.template.query(GETPAGENUM, new Integer[]{dataType}, new PageNum());
		if(ii == null){
			return 0;
		}
		return ii.get(0);
	}

	@Override
	public boolean deleteEventByEventId(int eventId) {
		// TODO Auto-generated method stub
		int res = this.template.update(DELETE_BY_EVENT_ID,eventId);
		return res > 0;
	}

	@Override
	public List<Event> searchEventByUserId(int userId) {
		// TODO Auto-generated method stub
		return (List<Event>) template.query(SEARCH_BY_USER_ID,new Integer[]{userId},new BeanPropertyRowMapper<Event>(Event.class));
	}

	
	@Override
	public Event MapToObject(Map<String, Object> map) {
		// TODO Auto-generated method stub
		if (map == null) {  
            return null;  
        }
		Event event = new Event();
		event.setEve_id((int)map.get("eve_id"));
		event.setUse_id((int)map.get("use_id"));
		event.setEve_count((int)map.get("eve_count"));
		event.setEve_positivecount((int)map.get("eve_positivecount"));
		event.setEve_question((String)map.get("eve_question"));
		event.setEve_time(map.get("eve_time") + "");
		event.setEve_longitude((float)map.get("eve_longitude"));
		event.setEve_latitude((float)map.get("eve_latitude"));
		event.setEve_datatype((int)map.get("eve_datatype"));
		event.setEve_puretext((String)map.get("eve_puretext"));
		event.setEve_audiourl((String)map.get("eve_audiourl"));
		event.setEve_pictureurl((String)map.get("eve_pictureurl"));
		event.setEve_description((String)map.get("eve_description"));
		event.setEve_remark((String)map.get("eve_remark"));
		return event;
	}
	
	@Override
	public int getEventCount() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Integer> lec = this.template.query("select count(*) from tb_event",new EventCount());
		if(lec==null)
			return 0;
		return lec.get(0);
	}
	
	@SuppressWarnings("rawtypes")
	class EventCount implements RowMapper {
		public Object mapRow(ResultSet rs, int index) throws SQLException {			
			return rs.getInt(1);
		}
	}
	@Override
	public List<Event> getAllEvent(){
		return  (List<Event>) template.query("select * from tb_event",new BeanPropertyRowMapper<Event>(Event.class));
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int countPageUse_id(int use_id, int eve_datatype, int page_length) {
		String sql = "SELECT COUNT(*) AS count_result FROM tb_event WHERE eve_datatype = ? and use_id = ? ";
		LogUtils.sysoln(sql);
		Integer[] args = { eve_datatype, use_id };
		List<Integer> list = (List<Integer>) template.query(sql, args, new CountPageMapper());
		if (list == null) {
			return 0;
		}
		int allRows = list.get(0);
		if (allRows / page_length * page_length == allRows) {
			return allRows / page_length;
		}
		return allRows / page_length + 1;
	}
}
