package com.hsp.kadori.web;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hsp.kadori.domain.Post;
import com.hsp.kadori.domain.User;
import com.hsp.kadori.dto.PostDTO;
import com.hsp.kadori.service.PostService;
import com.hsp.kadori.service.UserService;

@RestController
public class HomeController implements ErrorController {

	@Inject
	PostService postService;
	
	@Inject
	UserService userService;
	
	public HomeController() {
	}

	
	private static final String PATH = "/error";
	
	@RequestMapping(value = PATH)
	public ModelAndView error() {
		return new ModelAndView("error");
	}
	
	@Override
	public String getErrorPath() {
		return PATH;
	}
	
	@RequestMapping(value="/")
	public ModelAndView home(final Model model) {
		User user = userService.getLoggedInUser();
		List<Post> posts = postService.getPosts(user);
		
		model.addAttribute("postsList", posts);
		model.addAttribute("postDTO", new Post());
		
		return new ModelAndView("home", "postsList", posts);
	}
	
	@RequestMapping(value="/new_Post", method = RequestMethod.POST)
	public ModelAndView newPost(final Model model, @ModelAttribute("postDTO") PostDTO post, final BindingResult result, final Errors errors, final HttpServletRequest request) {
		User loggedInUser = userService.getLoggedInUser();
		List<Post> posts = postService.getPosts(loggedInUser);
		
		if (!result.hasErrors() && loggedInUser != null) {
			post.setUser(loggedInUser);
			post.setCreationTime(new Date());
			Post newPost = postService.addNewPost(post);
			
			//clear content to show empty textbox
			post.setContent("");
			
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
