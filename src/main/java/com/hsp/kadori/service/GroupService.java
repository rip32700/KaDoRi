package com.hsp.kadori.service;

import java.util.List;

import com.hsp.kadori.domain.Group;
import com.hsp.kadori.domain.User;
import com.hsp.kadori.dto.GroupDTO;

public interface GroupService {
	Group save(GroupDTO group);
	Group getGroupById(long groupId);
	List<User> getGroupMembers(long groupId);
}
