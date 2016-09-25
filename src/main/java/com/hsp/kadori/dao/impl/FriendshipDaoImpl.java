package com.hsp.kadori.dao.impl;

import javax.inject.Inject;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.hsp.kadori.dao.FriendshipDao;
import com.hsp.kadori.domain.Friendship;
import com.hsp.kadori.domain.User;

public class FriendshipDaoImpl implements FriendshipDao {

	private static final String Friendship_URI_V1 = "http://localhost:8181/friendship/";
	private RestTemplate restTemplate = new RestTemplate();

	@Inject
	HttpEntity<String> request;
	
	@Override
	public Friendship save(Friendship friendship) {
		restTemplate.postForLocation(Friendship_URI_V1, friendship);
		return friendship;
	}

	@Override
	public void delete(User user1, User user2) {
		// TODO Auto-generated method stub
	}

}
