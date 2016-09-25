package com.hsp.kadori.dao;

import com.hsp.kadori.domain.Friendship;
import com.hsp.kadori.domain.User;

public interface FriendshipDao {
	Friendship save(Friendship friendship);
	void delete(User user1, User user2);
}
