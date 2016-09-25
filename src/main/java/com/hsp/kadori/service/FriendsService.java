package com.hsp.kadori.service;

import java.util.List;

import com.hsp.kadori.domain.User;

public interface FriendsService {

	List<User> getAllFriends(final User loggedInUser);
	void addFriendship(User user1, User user2);
	void removeFriendship(User user1, User user2);
}
