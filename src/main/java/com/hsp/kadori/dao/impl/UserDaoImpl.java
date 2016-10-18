package com.hsp.kadori.dao.impl;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hsp.kadori.dao.UserDao;
import com.hsp.kadori.domain.Group;
import com.hsp.kadori.domain.User;

public class UserDaoImpl implements UserDao {

	private static final String USER_URI_V1 = "http://localhost:8181/user/";
	private RestTemplate restTemplate = new RestTemplate();

	@Inject
	HttpEntity<String> request;
	
	@Inject
	HttpHeaders headers;

	@Override
	public User findUserById(Long userId) {
		ResponseEntity<User> respone = restTemplate.exchange(USER_URI_V1 + "/{userId}", HttpMethod.GET, request,
				User.class, userId);
		return respone.getBody();
	}

	@Override
	public List<User> findAllUsers() {
		ResponseEntity<User[]> respone = restTemplate.exchange(USER_URI_V1 + "/all", HttpMethod.GET, request,
				User[].class);
		List<User> userList = Arrays.asList(respone.getBody());
		return userList;
	}

	@Override
	public User save(User user) {
		HttpEntity<Object> request = new HttpEntity<>(user, headers);
		ResponseEntity<User> response = restTemplate.postForEntity(USER_URI_V1, request, User.class);
		return response.getBody();
	}
	
	@Override
	public void delete(final long userId) {
		HttpEntity<Object> request = new HttpEntity<>(userId, headers);
		restTemplate.postForEntity(USER_URI_V1 + "delete", request, User.class);
	}

	@Override
	public User findByEmail(String email) {
		List<User> userList = findAllUsers();
		for (User user : userList) {
			if (user.getEmail().equals(email)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User findByUsername(String username) {
		List<User> userList = findAllUsers();
		for (User user : userList) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> findAllFriends(final long userId) {
		ResponseEntity<User[]> respone = restTemplate.exchange(USER_URI_V1 + "/{userId}/friends", HttpMethod.GET, request,
				User[].class, userId);
		List<User> friendsList = Arrays.asList(respone.getBody());
		
		return friendsList;
	}
	
	@Override
	public List<Group> getGroups(final long userId) {
		ResponseEntity<Group[]> respone = restTemplate.exchange(USER_URI_V1 + "/{userId}/groups", HttpMethod.GET, request, Group[].class, userId);
		List<Group> groups = Arrays.asList(respone.getBody());
		
		return groups;
	}

	@Override
	public List<User> findAvailableFriends(User me) {
		ResponseEntity<User[]> response = restTemplate.exchange(USER_URI_V1 + "/{userId}/availableFriends", HttpMethod.GET, request, User[].class, me.getUserId());
		List<User> users = Arrays.asList(response.getBody());
		
		return users;
	}

	@Override
	public List<Group> getJoinableGroups(User me) {
		ResponseEntity<Group[]> response = restTemplate.exchange(USER_URI_V1 + "/{userId}/joinableGroups", HttpMethod.GET, request, Group[].class, me.getUserId());
		List<Group> groups = Arrays.asList(response.getBody());
		
		return groups;
	}
	

}
