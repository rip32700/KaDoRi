package com.hsp.kadori.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hsp.kadori.domain.Group;
import com.hsp.kadori.domain.Post;
import com.hsp.kadori.domain.User;
import com.hsp.kadori.dto.PostDTO;
import com.hsp.kadori.service.GroupService;
import com.hsp.kadori.service.PostService;
import com.hsp.kadori.service.UserService;

@Controller
public class GroupController {

	private List<Post> posts = new ArrayList<>();
	private Group group = null;
	
	@Inject
	PostService postService;
	
	@Inject
	UserService userService;
	
	@Inject
	GroupService groupService;
	
	public GroupController() {
	}
	
	@RequestMapping(value="/group/{groupId}")
	public String loadGroupPage(final Model model, @PathVariable("groupId") long groupId) {
		this.group = groupService.getGroupById(groupId);
		model.addAttribute("group", group);

		posts = postService.getGroupPosts(groupId);
		Collections.reverse(posts);
		
		model.addAttribute("groupPostsList", posts);
		model.addAttribute("postDTO", new Post());
		
		return "group";
	}
	
	@RequestMapping(value="/my_groups")
	public String loadMyGroupsPage(final Model model) {
		User user = userService.getLoggedInUser();
		List<Group> groups = userService.getGroups(user);
		
		model.addAttribute("groupsList", groups);
		
		return "my_groups";
	}
	
	@RequestMapping(value="/group/{groupId}/new_Post", method = RequestMethod.POST)
	public ModelAndView newPost(final Model model, @ModelAttribute("postDTO") PostDTO post, final BindingResult result, final Errors errors, final HttpServletRequest request) {
		model.addAttribute("group", group);
		User user = userService.getLoggedInUser();
		
		if (!result.hasErrors() && user != null) {
			if(group != null) {
				post.setGroup(this.group);
			}
			post.setUser(user);
			post.setCreationTime(new Date());
			Post newPost = postService.addNewPost(post);
			
			//clear content to show an empty textbox
			post.setContent("");
			
			if(newPost != null) {
				posts.add(0, newPost);
			}
	    }
	    if (result.hasErrors()) {
	        return null; //TODO
	    } else {
	        return new ModelAndView("group", "groupPostsList", posts);
	    }
	}	
}