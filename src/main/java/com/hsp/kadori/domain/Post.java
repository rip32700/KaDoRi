package com.hsp.kadori.domain;

import java.util.Date;

public class Post {
	
	private Long postId;
	private String content;
	private Date creationTime;
	private Group group;
	private boolean isPublic;
	private User user;
	
	public Post() {
		
	}
	
	public Post (Long postId, String content, Date creationTime, boolean isPublic, User user) {
		super();
		this.postId = postId;
		this.content = content;
		this.creationTime = creationTime;
		this.isPublic = isPublic;
		this.user = user;
	}
	
	public Post (Long postId, String content, Date creationTime, boolean isPublic, Group group, User user) {
		super();
		this.postId = postId;
		this.content = content;
		this.creationTime = creationTime;
		this.isPublic = isPublic;
		this.group = group;
		this.user = user;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Post) {
			Post otherPost = (Post) obj;
			if(this.user.getUsername().equals(otherPost.getUser().getUsername())) {
				if(this.creationTime.equals(otherPost.getCreationTime())) {
					if(this.content.equals(otherPost.getContent())) {
						return true;
					}
				}
			}
		}
		return super.equals(obj);
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
