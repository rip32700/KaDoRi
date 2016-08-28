package com.hsp.kadori.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.web.client.RestTemplate;

import com.hsp.kadori.dao.PostDao;
import com.hsp.kadori.domain.Post;
import com.hsp.kadori.domain.User;

public class PostDaoImpl implements PostDao {
	private static final String POST_URI_V1 = "http://localhost:8181/post/";
	private RestTemplate restTemplate = new RestTemplate();
	
	@Inject
	JdbcOperations jdbcOperations;

	@Inject
	HttpEntity<String> request;
	
	@Override
	public Post save(Post post) {
//		restTemplate.exchange(POST_URI_V1, HttpMethod.POST, request,
//				Post[].class, post);
//		restTemplate.postForLocation(POST_URI_V1, post);
		// TODO Auto-generated method stub
		return post;
	}

	@Override
	public List<Post> getPostsOfFriends(User me) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPublicPosts() {
		// TODO Auto-generated method stub
		return null;
	}

}
