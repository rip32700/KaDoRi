package com.hsp.kadori.dao.impl;

import javax.inject.Inject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.hsp.kadori.dao.GroupMemberDao;
import com.hsp.kadori.domain.GroupMember;

public class GroupMemberDaoImpl implements GroupMemberDao {
	
	private static final String GROUP_MEMBER_URI_V1 = "http://localhost:8181/groupmember/";
	private RestTemplate restTemplate = new RestTemplate();

	@Inject
	HttpEntity<String> request;
	
	@Inject
	HttpHeaders headers;
	
	@Override
	public GroupMember save(GroupMember gm) {
		HttpEntity<Object> request = new HttpEntity<>(gm, headers);
		return restTemplate.postForEntity(GROUP_MEMBER_URI_V1, request, GroupMember.class).getBody();
	}

}
