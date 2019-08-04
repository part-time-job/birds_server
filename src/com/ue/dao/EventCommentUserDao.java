package com.ue.dao;

import com.ue.domain.EventCommentUser;

public interface EventCommentUserDao {

	/**
	 * 通过eventIid获取与该event相关的user以及该event的comments
	 * @param event_id
	 * @return
	 */
	EventCommentUser getViewByEventId(int event_id);

	long countBirds();

}