package com.hsp.kadori.dto;

import java.util.Date;

import com.hsp.kadori.domain.Group;
import com.hsp.kadori.domain.User;

public class PostDTO {
	private Long postId;
	private String content;
	private Date creationTime;
	private boolean isPublic;

	private Group group;
	private User user;
	
	public PostDTO() {
		
	}
	
	public PostDTO (Long postId, String content, Date creationTime, boolean isPublic, User user) {
		super();
		this.postId = postId;
		this.content = content;
		this.creationTime = creationTime;
		this.isPublic = isPublic;
		this.user = user;
	}
	
	public PostDTO (Long postId, String content, Date creationTime, boolean isPublic, Group group, User user) {
		super();
		this.postId = postId;
		this.content = content;
		this.creationTime = creationTime;
		this.isPublic = isPublic;
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
	
	public boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
}
