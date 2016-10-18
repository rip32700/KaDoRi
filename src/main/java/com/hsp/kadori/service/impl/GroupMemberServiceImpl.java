package com.hsp.kadori.service.impl;

import javax.inject.Inject;

import com.hsp.kadori.dao.GroupMemberDao;
import com.hsp.kadori.domain.Group;
import com.hsp.kadori.domain.GroupMember;
import com.hsp.kadori.domain.User;
import com.hsp.kadori.service.GroupMemberService;

public class GroupMemberServiceImpl implements GroupMemberService{

	@Inject
	GroupMemberDao repository;
	
	@Override
	public GroupMember createGroupMember(User user, Group group) {
		return repository.save(new GroupMember(group, user));
	}
	
	@Override
	public void removeGroupMember(User user, Group group) {
		repository.delete(new GroupMember(group, user));
	}

}
