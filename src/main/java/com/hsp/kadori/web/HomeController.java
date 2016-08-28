package com.hsp.kadori.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hsp.kadori.domain.Post;
import com.hsp.kadori.domain.User;
import com.hsp.kadori.dto.PostDTO;
import com.hsp.kadori.service.PostService;

@Controller
public class HomeController {

	private List<Post> posts = new ArrayList<>();
//	private static int counter = 0;
	
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
		model.addAttribute("postDTO", new Post());

		return "home";
	}
	
	@RequestMapping(value="/new_Post", method = RequestMethod.POST)
	public ModelAndView newPost(final Model model, @ModelAttribute("postDTO") PostDTO post, final BindingResult result, final Errors errors, final HttpServletRequest request) {
//		counter++;
//		Post anotherPost = new Post(1l, "Test "+counter, date, anotherUser);
//		posts.add(anotherPost);
		User anotherUser = new User();
		anotherUser.setUsername("kaa33477");
		Date date = new Date();
		
		Post newPost = new Post();
		
		if (!result.hasErrors()) {
			post.setUser(anotherUser);
			post.setCreationTime(date);
			newPost = service.addNewPost(post);
			posts.add(newPost);
	    }
	    if (result.hasErrors()) {
	        return new ModelAndView("newPost", "postDTO", post);
	    } else {
	        return new ModelAndView("home", "postDTO", post);
	    }
	}
	
}
