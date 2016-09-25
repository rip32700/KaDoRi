package com.hsp.kadori.web;

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

import com.hsp.kadori.domain.Group;
import com.hsp.kadori.domain.User;
import com.hsp.kadori.dto.UserDTO;
import com.hsp.kadori.service.GroupService;
import com.hsp.kadori.service.UserService;

@Controller
public class ExploreController {
	
	@Inject
	GroupService groupService;
	
	@Inject
	UserService userService;
	
	public ExploreController() {
	}
	
	@RequestMapping("/explore")
	public ModelAndView loadExplorePage(Model model) {
		User loggedInUser = userService.getLoggedInUser();
		List<User> availableFriends = null;
		List<Group> availableGroups = null;
		if(loggedInUser == null) {
			//TODO: get all users
		} else {
			availableFriends = userService.getAvailableFriends(loggedInUser);
			availableGroups = userService.getAvailableGroups(loggedInUser);
		}
		model.addAttribute("availableFriends", availableFriends);
		model.addAttribute("availableGroups", availableGroups);
		
		return new ModelAndView("explore");
	}
	
	
	@RequestMapping(value="/explore/search_request", method=RequestMethod.POST)
	public ModelAndView search(final Model model, @ModelAttribute("userDTO") UserDTO user, final BindingResult result, final Errors errors, final HttpServletRequest request) {
		
		return new ModelAndView("search_result");
	}
}
