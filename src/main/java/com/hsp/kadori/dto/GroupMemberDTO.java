package com.hsp.kadori.dto;

import com.hsp.kadori.domain.Group;
import com.hsp.kadori.domain.User;

public class GroupMemberDTO {
	private Long groupMemberId;
	private Group group;
	private User user;
	
	public GroupMemberDTO() {
	}
	
	public GroupMemberDTO (Group group, User user) {
		super();
		this.group = group;
		this.user = user;
	}
	
	public GroupMemberDTO (Long groupMemberId, Group group, User user) {
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
