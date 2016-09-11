package com.hsp.kadori.dao.impl;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hsp.kadori.dao.GroupDao;
import com.hsp.kadori.domain.Group;
import com.hsp.kadori.domain.User;

public class GroupDaoImpl implements GroupDao {
	private static final String POST_URI_V1 = "http://localhost:8181/group/";
	private RestTemplate restTemplate = new RestTemplate();

	@Inject
	HttpEntity<String> request;

	@Override
	public Group getGroupById(long groupId) {
		ResponseEntity<Group> respone = restTemplate.exchange(POST_URI_V1 + "/{groupId}", HttpMethod.GET, request, Group.class, groupId);
		Group group = respone.getBody();
		
		return group;
	}

	@Override
	public List<User> getGroupMembers(long groupId) {
		ResponseEntity<User[]> respone = restTemplate.exchange(POST_URI_V1 + "/{groupId}/members", HttpMethod.GET, request, User[].class, groupId);
		return Arrays.asList(respone.getBody());
	}
	
}
