package com.hsp.kadori.domain;

public class GroupMember {
	
	private Long groupMemberId;
	private Group group;
	private User user;
	
	public GroupMember (Long groupMemberId, Group group, User user) {
		super();
		this.groupMemberId = groupMemberId;
		this.group = group;
		this.user = user;
	}
	
	public Long getGroupMemberId() {
		return groupMemberId;
	}
	
	public void setGroupMemberId(Long groupMemberId) {
		this.groupMemberId = groupMemberId;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public void setGroup(Group group) {
		this.group = group;
	}
}
