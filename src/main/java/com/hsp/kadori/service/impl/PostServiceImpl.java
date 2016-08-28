package com.hsp.kadori.service.impl;

import javax.inject.Inject;

import com.hsp.kadori.dao.PostDao;
import com.hsp.kadori.domain.Post;
import com.hsp.kadori.dto.PostDTO;
import com.hsp.kadori.service.PostService;

public class PostServiceImpl implements PostService {

	@Inject PostDao repository;
	
	@Override
	public Post addNewPost(PostDTO post) {
		Post newPost = new Post();
		newPost.setContent(post.getContent());
		newPost.setCreationTime(post.getCreationTime());
		newPost.setUser(post.getUser());
		
		return repository.save(newPost);
	}

}
