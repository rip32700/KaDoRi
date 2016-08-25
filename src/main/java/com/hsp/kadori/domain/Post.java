package com.hsp.kadori.domain;

import java.util.Date;

public class Post {
	
	private Long postId;
	private String content;
	private Date creationTime;
	private Group group;
	private User user;
	
	public Post() {
		
	}
	
	public Post (Long postId, String content, Date creationTime, User user) {
		super();
		this.postId = postId;
		this.content = content;
		this.creationTime = creationTime;
		this.user = user;
	}
	
	public Post (Long postId, String content, Date creationTime, Group group, User user) {
		super();
		this.postId = postId;
		this.content = content;
		this.creationTime = creationTime;
		this.group = group;
		this.user = user;
	}
	
	public Long getPostId() {
		return postId;
	}
	
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCreationTime() {
		return creationTime;
	}
	
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public void setGroup(Group group) {
		this.group = group;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
