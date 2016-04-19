package com.hsp.kadori.web;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsp.kadori.domain.Post;
import com.hsp.kadori.domain.User;
import com.hsp.kadori.service.PostService;

@Controller
public class HomeController {

	private List<Post> posts = new ArrayList<>();
	
	@Inject
	PostService service;
	
	public HomeController() {
		// dummy data
		User aUser = new User("rip32700");
		Post aPost = new Post(aUser, LocalDate.now(), LocalDate.now(), "First Post", "Hello World Post.");
		
		User anotherUser = new User("kaa3333");
		Post anotherPost = new Post(anotherUser, LocalDate.now(), LocalDate.now(), "Another Test Post", "With some random text.");
		
		posts.add(aPost);
		posts.add(anotherPost);
	}
	
	@RequestMapping(value="/")
	public String home(final Model model) {
		model.addAttribute("postsList", posts);
		
		return "home";
	}
	
}
