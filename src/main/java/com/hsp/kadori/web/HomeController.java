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

import com.hsp.kadori.dao.PostDao;
import com.hsp.kadori.dao.UserDao;
import com.hsp.kadori.domain.Post;
import com.hsp.kadori.domain.User;
import com.hsp.kadori.dto.PostDTO;
import com.hsp.kadori.service.PostService;
import com.hsp.kadori.web.utils.UserUtils;

@Controller
public class HomeController {

	private List<Post> posts = new ArrayList<>();
	
	@Inject
	PostService service;
	
	@Inject
	UserDao userRepository;
	@Inject
	PostDao postRepository;
	
	public HomeController() {
	}
	
	@RequestMapping(value="/")
	public String home(final Model model) {
		List<Post> publicPosts = postRepository.getPublicPosts();
		if(publicPosts != null) {
			for (Post post : publicPosts) {
				if(post != null) {
					if(!posts.contains(post)) {
						posts.add(0, post);
					}
				}
			}
		}

		model.addAttribute("postsList", posts);
		model.addAttribute("postDTO", new Post());
		
		return "home";
	}
	
	@RequestMapping(value="/new_Post", method = RequestMethod.POST)
	public ModelAndView newPost(final Model model, @ModelAttribute("postDTO") PostDTO post, final BindingResult result, final Errors errors, final HttpServletRequest request) {
		Post newPost = new Post();
		
		String username = UserUtils.getCurrentUserName();
		User user = userRepository.findByUsername(username);
		
		if (!result.hasErrors() && user != null) {
			post.setUser(user);
			post.setCreationTime(new Date());
			post.setIsPublic(true); //TODO: add mechanism to check/uncheck public
			newPost = service.addNewPost(post);
			posts.add(0, newPost);
	    }
	    if (result.hasErrors()) {
	        return null; //TODO
	    } else {
	        return new ModelAndView("home", "postsList", posts);
	    }
	}	
}
