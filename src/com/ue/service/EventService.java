package com.ue.service;

import java.util.List;

import com.ue.domain.Event;

public interface EventService {


	
	List<Event> findEventsByUse_id_page(int current_page, int use_id,  int eve_datatype, int page_length);

	/**
	 * 
	 * 向数据库添加一个对象
	 * 
	 * @param event 对应的对象
	 * @return 整数表示添加成功，否则添加失败
	 */
	boolean insertEvent(Event event);
	
	
	/**
	 * 
	 * @param current_page
	 * @param eve_datatype
	 * @param page_length
	 * @return
	 */
	List<Event> findEventsByPage(int current_page,int eve_datatype, int page_length);
	

	int countPage(int eve_datatype,int page_length);

	int getPageNum(int i);

	List<Event> getAudioTopTen();

	
	
	/**
	 * 删除一个事件
	 * @param eventId 要删除的事件id
	 * @return
	 */
	boolean deleteEventByEventId(int eventId);

	/**
	 * 更新一个事件
	 * @param event 要更新的事件
	 * @return
	 */
	boolean updateEventByEventId(Event event);

	/**
	 * 按照事件id查找一个事件
	 * @param eventId 事件id
	 * @return
	 */
	Event searchEventByEventId(int eventId);
	
	/**
	 * 按照用户id查找事件
	 * @param userId 用户id
	 * @return
	 */
	List<Event> searchEventByUserId(int userId);
	
	/**
	 * 在所有用户事件中分页查找文本信息事件
	 * @param pageNow 当前页数
	 * @return
	 */
	List<Event> searchEventPuretextByPage(int pageNow);
	
	/**
	 * 在特定用户事件中分页查找文本事件
	 * @param pageNow 当前页数
	 * @param userId 用户id
	 * @return
	 */
	List<Event> searchEventPuretextByPage(int pageNow,int userId);
	
	/**
	 * 在所有用户事件中分页查找图片信息事件
	 * @param pageNow 当前页数
	 * @return
	 */
	List<Event> searchEventPictureByPage(int pageNow);
	
	/**
	 * 在特定事件中分页查找图片事件信息
	 * @param pageNow 当前页数
	 * @param userId 用户id
	 * @return
	 */
	List<Event> searchEventPictureByPage(int pageNow,int userId);
	
	/**
	 * 在所有用户事件中分页查找音频信息事件
	 * @param pageNow 当前页数
	 * @return
	 */
	List<Event> searchEventAudioByPage(int pageNow);
	
	/**
	 * 在特定用户事件中查找音频信息事件
	 * @param pageNow 当前页数
	 * @param userId 用户id
	 * @return
	 */
	List<Event> searchEventAudioByPage(int pageNow,int userId);

	int getEventCount();

	List<Event> getAllEvent();
	
	int countPageUse_id(int use_id, int eve_datatype, int page_length);
	
}