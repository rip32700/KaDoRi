package com.hsp.kadori.dao;

import com.hsp.kadori.domain.GroupMember;

public interface GroupMemberDao {
	GroupMember save(GroupMember gm);
	void delete(GroupMember gm);
}
