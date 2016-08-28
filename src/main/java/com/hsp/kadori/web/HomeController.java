package com.hsp.kadori.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
	
	@Inject
	PostService service;
	
	public HomeController() {
	}
	
	@RequestMapping(value="/")
	public String home(final Model model) {
		model.addAttribute("postsList", posts);
		model.addAttribute("postDTO", new Post());

		return "home";
	}
	
	@RequestMapping(value="/new_Post", method = RequestMethod.POST)
	public ModelAndView newPost(final Model model, @ModelAttribute("postDTO") PostDTO post, final BindingResult result, final Errors errors, final HttpServletRequest request) {
		User user = new User();
		Post newPost = new Post();
		
		String username = getCurrentUserName();
		user.setUsername(username);
		
		if (!result.hasErrors()) {
			post.setUser(user);
			post.setCreationTime(new Date());
			newPost = service.addNewPost(post);
			posts.add(0, newPost);
	    }
	    if (result.hasErrors()) {
	        return null; //TODO
	    } else {
	        return new ModelAndView("home", "postsList", posts);
	    }
	}

	private String getCurrentUserName() {
		String username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		return username;
	}
	
}
