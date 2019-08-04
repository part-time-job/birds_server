package com.ue.service;

import java.util.ArrayList;
import java.util.List;

import com.ue.config.ServerConfig;
import com.ue.dao.EventDao;
import com.ue.domain.Event;
import com.ue.utils.BeanUtils;

public class EventServiceImp implements EventService {

	private EventDao eventDao;
	public final int DATATYPE_PURETEXT = 0;
	public final int DATATYPE_PICTURE = 1;
	public final int DATATYPE_AUDIO = 2;

	public EventServiceImp() {
		eventDao = (EventDao) BeanUtils.getBean("eventDao");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ue.dao.PureTextService#findEventsByUse_id_page(int, int, int)
	 */
	@Override
	public List<Event> findEventsByUse_id_page(int current_page, int use_id, int eve_datatype, int page_length) {
		if(current_page <= -1 || use_id <= 0 || eve_datatype >= 3 || eve_datatype < 0 || page_length <= 0){
			return new ArrayList<>();
		}		
		return eventDao.findEventsByUse_id_page(current_page, use_id, eve_datatype, page_length);
	}

	@Override
	public boolean insertEvent(Event event) {
		if(event == null){
			return false;
		}
		// TODO Auto-generated method stub
		return eventDao.insertEvent(event);
	}

	@Override
	public List<Event> findEventsByPage(int current_page, int eve_datatype, int page_length) {
		if(current_page <= -1 || eve_datatype >= 3 || eve_datatype < 0 || page_length <= 0){
			return new ArrayList<>();
		}
		return eventDao.findEventsByPage(current_page, eve_datatype, page_length);
	}

	@Override
	public int countPage(int eve_datatype, int page_length) {
		if(eve_datatype >= 3 || eve_datatype < 0 || page_length <= 0){
			return 1;
		}
		return eventDao.countPage(eve_datatype, page_length);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ue.service.EventService#searchEventAudioByPage(int)
	 */
	@Override
	public List<Event> searchEventAudioByPage(int pageNow) {
		if(pageNow <= 0){
			return new ArrayList<>();
		}
		return eventDao.searchEventByPage(pageNow, ServerConfig.PURETEXT_PAGE_SIZE, this.DATATYPE_AUDIO, false, 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ue.service.EventService#searchEventAudioByPage(int, int)
	 */
	@Override
	public List<Event> searchEventAudioByPage(int pageNow, int userId) {
		if(pageNow <= 0 || userId <= 0){
			return new ArrayList<>();
		}
		return eventDao.searchEventByPage(pageNow, ServerConfig.PURETEXT_PAGE_SIZE, this.DATATYPE_AUDIO, true, userId);
	}
	/* (non-Javadoc)
	 * @see com.ue.service.EventService#searchEventByEventId(int)
	 */
	@Override
	public Event searchEventByEventId(int eventId) {
		if(eventId <= 0){
			return null;
		}
		return eventDao.searchEventByEventId(eventId);
	}


	/* (non-Javadoc)
	 * @see com.ue.service.EventService#updateEventByEventId(com.ue.domain.Event)
	 */
	public boolean updateEventByEventId(Event event) {
		if(event == null){
			return false;
		}
		return eventDao.updateEventByEventId(event);
	}

	/* (non-Javadoc)
	 * @see com.ue.service.EventService#getPageNum(int)
	 */
	@Override
	public int getPageNum(int dataType) {
		if(dataType < 0 || dataType >= 3){
			return 1;
		}
		return eventDao.getPageNum(dataType);
	}
	/* (non-Javadoc)
	 * @see com.ue.service.EventService#getAudioTopTen()
	 */
	@Override
	public List<Event> getAudioTopTen() {
		// TODO Auto-generated method stub
		return eventDao.getAudioTopTen();
	}

	

	@Override
	public List<Event> searchEventPictureByPage(int pageNow) {
		if(pageNow <= 0){
			return new ArrayList<>();
		}
		return eventDao.searchEventByPage(pageNow, ServerConfig.PICTURE_PAGE_SIZE, this.DATATYPE_PICTURE, false, 0);
	}

	
	@Override
	public boolean deleteEventByEventId(int eventId) {
		if(eventId <= 0){
			return false;
		}
		return eventDao.deleteEventByEventId(eventId);
	}

	@Override
	public List<Event> searchEventByUserId(int userId) {
		if(userId <= 0){
			return new ArrayList<>();
		}
		return eventDao.searchEventByUserId(userId);
	}

	@Override
	public List<Event> searchEventPuretextByPage(int pageNow) {
		if(pageNow <= 0){
			return new ArrayList<>();
		}
		return eventDao.searchEventByPage(pageNow, ServerConfig.PURETEXT_PAGE_SIZE, this.DATATYPE_PURETEXT, false, 0);
	}

	@Override
	public List<Event> searchEventPuretextByPage(int pageNow, int userId) {
		if(pageNow <= 0 || userId <= 0){
			return new ArrayList<>();
		}
		return eventDao.searchEventByPage(pageNow, ServerConfig.PURETEXT_PAGE_SIZE, this.DATATYPE_PURETEXT, true, userId);
	}

	@Override
	public List<Event> searchEventPictureByPage(int pageNow, int userId) {
		if(pageNow <= 0 || userId <= 0){
			return new ArrayList<>();
		}
		return eventDao.searchEventByPage(pageNow, ServerConfig.PICTURE_PAGE_SIZE, this.DATATYPE_PICTURE, false, 0);
	}
	
	@Override
	public int getEventCount(){
		return eventDao.getEventCount();
	}
	
	@Override
	public List<Event> getAllEvent(){
		return eventDao.getAllEvent();
	}
	
	@Override
	public int countPageUse_id(int use_id,int eve_datatype, int page_length) {
		if(use_id <= 0 || eve_datatype < 0 || eve_datatype > 2 || page_length <= 0){
			return 1;
		}
		return eventDao.countPageUse_id(use_id, eve_datatype, page_length);
	}
}
