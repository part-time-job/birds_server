package com.ue.service;

import java.util.ArrayList;
import java.util.List;

import com.ue.dao.CommentDao;
import com.ue.domain.Comment;
import com.ue.utils.BeanUtils;

public class CommentServiceImp implements CommentService   {
	CommentDao commentDao;
	
	public CommentServiceImp(){
		commentDao = (CommentDao) BeanUtils.getBean("commentDao");
	}
	
	/* (non-Javadoc)
	 * @see com.ue.service.CommentService#getCommentsByEventId(int)
	 */
	/* (non-Javadoc)
	 * @see com.ue.service.CommentService#getCommentsByEventId(int)
	 */
	@Override
	public List<Comment> getCommentsByEventId(int event_id){
		if(event_id <= 0){
			return new ArrayList<>();
		}
		return commentDao.searchCommentByEventId(event_id);
	}
	
	/* (non-Javadoc)
	 * @see com.ue.service.CommentService#InsertCommentByEventId(com.ue.domain.Comment)
	 */
	@Override
	public Boolean insertComment(Comment comment){
		if(comment == null){
			return false;
		}
		return commentDao.insertComment(comment);
	}
	
	@Override
	public long getCommentCount(){
		return commentDao.getCommentCount();
	}
}
