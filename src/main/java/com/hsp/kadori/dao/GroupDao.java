package com.hsp.kadori.dao;

import java.util.List;

import com.hsp.kadori.domain.Group;
import com.hsp.kadori.domain.User;

public interface GroupDao {
	Group getGroupById(long groupId);
	List<User> getGroupMembers(long groupId);
}
