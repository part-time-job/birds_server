package com.ue.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ue.domain.Event;

public interface EventDao extends Serializable {

	/**
	 * 鍒嗛〉鏌ユ壘
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
	 * 鍚戞暟鎹簱娣诲姞涓�涓璞�
	 * 
	 * @param event
	 *            瀵瑰簲鐨勫璞�
	 * @return 鏁存暟琛ㄧず娣诲姞鎴愬姛锛屽惁鍒欐坊鍔犲け璐�
	 */
	boolean insertEvent(Event event);

	int countPage(int eve_datatype, int page_length);

	List<Event> searchEventByPage(int pageNow, int puretextPageSize, int datatype_AUDIO, boolean b, int userId);

	Event searchEventByEventId(int eventId);

	boolean updateEventByEventId(Event event);

	List<Event> getAudioTopTen();

	int getPageNum(int dataType);

	// 鍒犻櫎
	boolean deleteEventByEventId(int eventId);

	List<Event> searchEventByUserId(int userId);

	// ORMapping
	Event MapToObject(Map<String, Object> map);

	int getEventCount();

	List<Event> getAllEvent();
	
	int countPageUse_id(int use_id, int eve_datatype, int page_length);

}