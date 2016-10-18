package com.hsp.kadori.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hsp.kadori.domain.User;
import com.hsp.kadori.service.FriendsService;
import com.hsp.kadori.service.UserService;

@Controller
public class FriendsController {
	
	@Inject
	FriendsService friendsService;
	
	@Inject
	UserService userService;
	
	public FriendsController() {
	}
	
	@RequestMapping(value="/my_friends")
	public ModelAndView myFriendsPage(final Model model) {
		User loggedInUser = userService.getLoggedInUser();
		if (loggedInUser.getEmail().equals("anonymousUser@ADManonymousUser.de")) {
			return new ModelAndView("redirect:/login");
		}
		
		List<User> friends = friendsService.getAllFriends(loggedInUser);
		model.addAttribute("friendsList", friends);
		
		return new ModelAndView("my_friends");
	}
}
