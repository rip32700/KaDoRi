package com.hsp.kadori.service;

import com.hsp.kadori.domain.Post;
import com.hsp.kadori.dto.PostDTO;

public interface PostService {
	Post addNewPost(final PostDTO post);
}
