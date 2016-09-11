package com.hsp.kadori.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.hsp.kadori.dao.PostDao;
import com.hsp.kadori.domain.Group;
import com.hsp.kadori.domain.Post;
import com.hsp.kadori.domain.User;
import com.hsp.kadori.dto.PostDTO;
import com.hsp.kadori.service.PostService;
import com.hsp.kadori.service.utils.PostUtils;

public class PostServiceImpl implements PostService {

	@Inject PostDao repository;
	
	@Override
	public Post addNewPost(PostDTO post) {
		Post newPost = new Post();
		newPost.setContent(post.getContent());
		newPost.setCreationTime(post.getCreationTime());
		newPost.setUser(post.getUser());
		newPost.setIsPublic(post.getIsPublic());
		
		return repository.save(newPost);
	}

	@Override
	public List<Post> getPosts(User user) {
		List<Post> postsOfFriends = new ArrayList<>();
		if(user!=null && !user.getEmail().equals("anonymousUser@ADManonymousUser.de")) {
			postsOfFriends = repository.getPostsOfFriends(user);
		}
		List<Post> publicPosts = repository.getPublicPosts();
		
		return PostUtils.mergeAndSort(publicPosts, postsOfFriends);
	}

	@Override
	public List<Post> getGroupPosts(long groupId) {
		List<Post> postsOfGroup = repository.getPostsOfGroup(groupId);
		
		return postsOfGroup;
	}

}
