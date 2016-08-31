package com.hsp.kadori.dao.impl;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.web.client.RestTemplate;

import com.hsp.kadori.dao.UserDao;
import com.hsp.kadori.domain.User;

public class UserDaoImpl implements UserDao {

	private static final String USER_URI_V1 = "http://localhost:8181/user/";
	private RestTemplate restTemplate = new RestTemplate();

	@Inject
	HttpEntity<String> request;

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
		/* URI uri = */ restTemplate.postForLocation(USER_URI_V1, user);
		return user;
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

}
