package com.ue.service;

import java.util.List;

import com.ue.domain.Event;

public interface EventService {


	
	List<Event> findEventsByUse_id_page(int current_page, int use_id,  int eve_datatype, int page_length);

	/**
	 * 
	 * 鍚戞暟鎹簱娣诲姞涓�涓璞�
	 * 
	 * @param event 瀵瑰簲鐨勫璞�
	 * @return 鏁存暟琛ㄧず娣诲姞鎴愬姛锛屽惁鍒欐坊鍔犲け璐�
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
	 * 鍒犻櫎涓�涓簨浠�
	 * @param eventId 瑕佸垹闄ょ殑浜嬩欢id
	 * @return
	 */
	boolean deleteEventByEventId(int eventId);

	/**
	 * 鏇存柊涓�涓簨浠�
	 * @param event 瑕佹洿鏂扮殑浜嬩欢
	 * @return
	 */
	boolean updateEventByEventId(Event event);

	/**
	 * 鎸夌収浜嬩欢id鏌ユ壘涓�涓簨浠�
	 * @param eventId 浜嬩欢id
	 * @return
	 */
	Event searchEventByEventId(int eventId);
	
	/**
	 * 鎸夌収鐢ㄦ埛id鏌ユ壘浜嬩欢
	 * @param userId 鐢ㄦ埛id
	 * @return
	 */
	List<Event> searchEventByUserId(int userId);
	
	/**
	 * 鍦ㄦ墍鏈夌敤鎴蜂簨浠朵腑鍒嗛〉鏌ユ壘鏂囨湰淇℃伅浜嬩欢
	 * @param pageNow 褰撳墠椤垫暟
	 * @return
	 */
	List<Event> searchEventPuretextByPage(int pageNow);
	
	/**
	 * 鍦ㄧ壒瀹氱敤鎴蜂簨浠朵腑鍒嗛〉鏌ユ壘鏂囨湰浜嬩欢
	 * @param pageNow 褰撳墠椤垫暟
	 * @param userId 鐢ㄦ埛id
	 * @return
	 */
	List<Event> searchEventPuretextByPage(int pageNow,int userId);
	
	/**
	 * 鍦ㄦ墍鏈夌敤鎴蜂簨浠朵腑鍒嗛〉鏌ユ壘鍥剧墖淇℃伅浜嬩欢
	 * @param pageNow 褰撳墠椤垫暟
	 * @return
	 */
	List<Event> searchEventPictureByPage(int pageNow);
	
	/**
	 * 鍦ㄧ壒瀹氫簨浠朵腑鍒嗛〉鏌ユ壘鍥剧墖浜嬩欢淇℃伅
	 * @param pageNow 褰撳墠椤垫暟
	 * @param userId 鐢ㄦ埛id
	 * @return
	 */
	List<Event> searchEventPictureByPage(int pageNow,int userId);
	
	/**
	 * 鍦ㄦ墍鏈夌敤鎴蜂簨浠朵腑鍒嗛〉鏌ユ壘闊抽淇℃伅浜嬩欢
	 * @param pageNow 褰撳墠椤垫暟
	 * @return
	 */
	List<Event> searchEventAudioByPage(int pageNow);
	
	/**
	 * 鍦ㄧ壒瀹氱敤鎴蜂簨浠朵腑鏌ユ壘闊抽淇℃伅浜嬩欢
	 * @param pageNow 褰撳墠椤垫暟
	 * @param userId 鐢ㄦ埛id
	 * @return
	 */
	List<Event> searchEventAudioByPage(int pageNow,int userId);

	int getEventCount();

	List<Event> getAllEvent();
	
	int countPageUse_id(int use_id, int eve_datatype, int page_length);
	
}