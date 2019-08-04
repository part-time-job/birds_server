package com.ue.domain;

import java.util.List;

public class EventCommentUser {
	private User user;
	private Event event;
	private List<Comment> comments;
	public EventCommentUser(){
		
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "EventCommentUserDaoImp [user=" + user + ", event=" + event + ", comments=" + comments.toString() + "]";
	}
	public EventCommentUser(User user, Event event, List<Comment> comments) {
		super();
		this.user = user;
		this.event = event;
		this.comments = comments;
	}
	
}
