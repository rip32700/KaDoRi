package com.hsp.kadori.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.hsp.kadori.dao.FriendshipDao;
import com.hsp.kadori.dao.UserDao;
import com.hsp.kadori.domain.Friendship;
import com.hsp.kadori.domain.User;
import com.hsp.kadori.service.FriendsService;

public class FriendsServiceImpl implements FriendsService {

	@Inject
	private UserDao userRepository;
	
	@Inject 
	FriendshipDao friendshipRepository;
	
	@Override
	public List<User> getAllFriends(final User user) {
		List<User> friends = userRepository.findAllFriends(user.getUserId());
		
		return friends;
	}

	@Override
	public void addFriendship(User user1, User user2) {
		friendshipRepository.save(new Friendship(user1, user2));
	}

	@Override
	public void removeFriendship(User user1, User user2) {
		friendshipRepository.delete(user1, user2);
	}
	
}
