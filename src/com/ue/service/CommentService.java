package com.ue.service;

import java.util.List;

import com.ue.domain.Comment;

public interface CommentService {

	/* (non-Javadoc)
	 * @see com.ue.service.CommentService#getCommentsByEventId(int)
	 */
	List<Comment> getCommentsByEventId(int event_id);

	Boolean insertComment(Comment comment);

	long getCommentCount();

}