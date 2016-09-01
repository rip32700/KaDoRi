package com.hsp.kadori.service;

import java.util.List;

import com.hsp.kadori.domain.Post;
import com.hsp.kadori.domain.User;
import com.hsp.kadori.dto.PostDTO;

public interface PostService {
	Post addNewPost(final PostDTO post);
	List<Post> getPosts(final User user);
}
