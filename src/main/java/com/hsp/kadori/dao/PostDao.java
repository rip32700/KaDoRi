package com.hsp.kadori.dao;

import java.util.List;

import com.hsp.kadori.domain.Post;
import com.hsp.kadori.domain.User;

public interface PostDao {
	Post save(Post post);
	List<Post> getPostsOfFriends(User me);
	List<Post> getPublicPosts();
}
