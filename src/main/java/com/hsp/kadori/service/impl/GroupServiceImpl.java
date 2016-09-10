package com.hsp.kadori.service.impl;

import javax.inject.Inject;

import com.hsp.kadori.dao.GroupDao;
import com.hsp.kadori.domain.Group;

public class GroupServiceImpl implements com.hsp.kadori.service.GroupService {

	@Inject
	GroupDao repository;

	@Override
	public Group getGroupById(long groupId) {
		Group group = repository.getGroupById(groupId);

		return group;
	}
	
}
