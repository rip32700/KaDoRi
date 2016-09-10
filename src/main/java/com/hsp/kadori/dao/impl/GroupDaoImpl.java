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
	
//	@Override
//	public List<Group> getGroups(User user) {
//		ResponseEntity<Group[]> respone = restTemplate.exchange(POST_URI_V1 + "/" + user.getUserId(), HttpMethod.GET, request, Group[].class);
//		List<Group> groups = Arrays.asList(respone.getBody());
//		
//		return groups;
//	}
	
}
