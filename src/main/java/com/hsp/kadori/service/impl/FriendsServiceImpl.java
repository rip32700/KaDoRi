package com.hsp.kadori.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.hsp.kadori.dao.UserDao;
import com.hsp.kadori.domain.User;
import com.hsp.kadori.service.FriendsService;

public class FriendsServiceImpl implements FriendsService {

	@Inject
	private UserDao userRepository;
	
	@Override
	public List<User> getAllFriends(final User user) {
		List<User> friends = userRepository.findAllFriends(user.getUserId());
		
		return friends;
	}
	
}
