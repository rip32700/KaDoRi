package com.hsp.kadori.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.hsp.kadori.dao.GroupDao;
import com.hsp.kadori.domain.Group;
import com.hsp.kadori.domain.User;
import com.hsp.kadori.dto.GroupDTO;

public class GroupServiceImpl implements com.hsp.kadori.service.GroupService {

	@Inject
	GroupDao repository;

	@Override
	public Group getGroupById(long groupId) {
		Group group = repository.getGroupById(groupId);

		return group;
	}

	@Override
	public List<User> getGroupMembers(long groupId) {
		return new ArrayList<User>(repository.getGroupMembers(groupId));
	}

	@Override
	public Group save(GroupDTO group) {
		return repository.addNewGroup(new Group(group.getDate(), group.getGroupDescription(), group.getGroupName()));
	}
}
