package com.hsp.kadori.service;

import java.util.List;

import com.hsp.kadori.domain.Group;
import com.hsp.kadori.domain.User;

public interface GroupService {
	Group getGroupById(long groupId);
	List<User> getGroupMembers(long groupId);
}
