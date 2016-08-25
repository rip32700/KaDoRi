package com.hsp.kadori.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hsp.kadori.domain.Post;
import com.hsp.kadori.domain.User;
import com.hsp.kadori.service.PostService;

@Controller
public class HomeController {

	private List<Post> posts = new ArrayList<>();
	private static int counter = 0;
	
	@Inject
	PostService service;
	
	public HomeController() {
		// dummy data
		/*User aUser = new User();
		aUser.setUsername("rip32700");
		Post aPost = new Post(aUser, LocalDate.now(), LocalDate.now(), "First Post", "Hello World Post.");
		
		User anotherUser = new User();
		anotherUser.setUsername("kaa33477");
		Post anotherPost = new Post(anotherUser, LocalDate.now(), LocalDate.now(), "Another Test Post", "With some random text.");
		
		posts.add(aPost);
		posts.add(anotherPost);*/
	}
	
	@RequestMapping(value="/")//, method = RequestMethod.POST)
	public String home(final Model model) {
		model.addAttribute("postsList", posts);

		return "home";
	}
	
	@RequestMapping(value="/new_Post", method = RequestMethod.POST)
	public String newPost(@ModelAttribute Post post, final Model model) {
		counter++;
		User anotherUser = new User();
		anotherUser.setUsername("kaa33477");
		Date date = new Date();
		Post anotherPost = new Post(1l, "Test "+counter, date, anotherUser);
		posts.add(anotherPost);
		
		model.addAttribute("postsList", posts);

		return "home";
	}
	
}
