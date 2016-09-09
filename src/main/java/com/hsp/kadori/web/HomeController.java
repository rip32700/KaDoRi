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
import com.hsp.kadori.service.UserService;

@Controller
public class HomeController {

	private List<Post> posts = new ArrayList<>();
	
	@Inject
	PostService postService;
	
	@Inject
	UserService userService;
	
	public HomeController() {
	}
	
	@RequestMapping(value="/")
	public String home(final Model model) {
		User user = userService.getLoggedInUser();
		posts = postService.getPosts(user);
		
		model.addAttribute("postsList", posts);
		model.addAttribute("postDTO", new Post());
		
		return "home";
	}
	
	@RequestMapping(value="/new_Post", method = RequestMethod.POST)
	public ModelAndView newPost(final Model model, @ModelAttribute("postDTO") PostDTO post, final BindingResult result, final Errors errors, final HttpServletRequest request) {
		User user = userService.getLoggedInUser();
		
		if (!result.hasErrors() && user != null) {
			post.setUser(user);
			post.setCreationTime(new Date());
			Post newPost = postService.addNewPost(post);
			
			if(newPost != null) {
				posts.add(0, newPost);
			}
	    }
	    if (result.hasErrors()) {
	        return null; //TODO
	    } else {
	        return new ModelAndView("home", "postsList", posts);
	    }
	}	
}
