package com.hsp.kadori.dao.impl;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hsp.kadori.dao.PostDao;
import com.hsp.kadori.domain.Post;
import com.hsp.kadori.domain.User;

public class PostDaoImpl implements PostDao {
	private static final String POST_URI_V1 = "http://localhost:8181/post/";
	private RestTemplate restTemplate = new RestTemplate();
	
	@Inject
	HttpEntity<String> request;
	
	@Inject
	HttpHeaders headers;
	
	@Override
	public Post save(Post post) {
		HttpEntity<Object> request = new HttpEntity<>(post, headers);
		return restTemplate.postForEntity(POST_URI_V1, request, Post.class).getBody();
	}
	

	@Override
	public List<Post> getPostsOfFriends(User me) {
		ResponseEntity<Post[]> respone = restTemplate.exchange(POST_URI_V1 + "/private/" + me.getUserId(), HttpMethod.GET, request, Post[].class);
		List<Post> postList = Arrays.asList(respone.getBody());
		return postList;
	}

	@Override
	public List<Post> getPublicPosts() {
		ResponseEntity<Post[]> respone = restTemplate.exchange(POST_URI_V1 + "/all_Public", HttpMethod.GET, request,
				Post[].class);
		List<Post> postList = Arrays.asList(respone.getBody());
		return postList;
	}


	@Override
	public List<Post> getPostsOfGroup(long groupId) {
		ResponseEntity<Post[]> respone = restTemplate.exchange(POST_URI_V1 + "/group/{groupId}", HttpMethod.GET, request, Post[].class, groupId);
		List<Post> postList = Arrays.asList(respone.getBody());

		return postList;
	}

}
