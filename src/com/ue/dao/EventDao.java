package com.ue.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ue.domain.Event;

public interface EventDao extends Serializable {

	/**
	 * 分页查找
	 * 
	 * @param eve_id_begin
	 * @param use_id
	 * @param eve_datatype
	 * @param page_length
	 * @return
	 */
	List<Event> findEventsByUse_id_page(int current_page, int use_id, int eve_datatype, int page_length);

	/**
	 * 
	 * @param current_page
	 * @param eve_datatype
	 * @param page_length
	 * @return
	 */
	List<Event> findEventsByPage(int current_page, int eve_datatype, int page_length);

	/**
	 * 
	 * 向数据库添加一个对象
	 * 
	 * @param event
	 *            对应的对象
	 * @return 整数表示添加成功，否则添加失败
	 */
	boolean insertEvent(Event event);

	int countPage(int eve_datatype, int page_length);

	List<Event> searchEventByPage(int pageNow, int puretextPageSize, int datatype_AUDIO, boolean b, int userId);

	Event searchEventByEventId(int eventId);

	boolean updateEventByEventId(Event event);

	List<Event> getAudioTopTen();

	int getPageNum(int dataType);

	// 删除
	boolean deleteEventByEventId(int eventId);

	List<Event> searchEventByUserId(int userId);

	// ORMapping
	Event MapToObject(Map<String, Object> map);

	int getEventCount();

	List<Event> getAllEvent();
	
	int countPageUse_id(int use_id, int eve_datatype, int page_length);

}