package com.hsp.kadori.service;

import com.hsp.kadori.domain.Group;
import com.hsp.kadori.domain.GroupMember;
import com.hsp.kadori.domain.User;

public interface GroupMemberService {
	GroupMember createGroupMember(User user, Group group);
}
