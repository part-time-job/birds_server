package com.ue.service;

import com.ue.dao.EventCommentUserDao;
import com.ue.dao.EventCommentUserDaoImp;
import com.ue.domain.EventCommentUser;

public class EventCommentUserServiceImp {
	EventCommentUserDao ecuDao = new EventCommentUserDaoImp();
	public EventCommentUser getFakeView(int event_id){
		if(event_id <= 0){
			return null;
		}
		return ecuDao.getViewByEventId(event_id);
	}
	
	public long countBirds(){
		return ecuDao.countBirds();
	}
}
