package com.ue.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ue.domain.Comment;

public interface CommentDao {

	JdbcTemplate getTemplate();

	void setTemplate(JdbcTemplate template);

	boolean insertComment(Comment comment);

	boolean deleteCommentByCommentId(int commentId);

	boolean updateCommentByCommentId(Comment comment);

	Comment searchCommentByCommentId(int commentId);

	List<Comment> searchCommentByEventId(int eventId);

	List<Comment> searchCommentByPage(int pageNow, int pageSize, int eventId);

	int getPageNum(int dataType);

	long getCommentCount();

}