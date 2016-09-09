package com.hsp.kadori.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String myFriendsPage(final Model model) {
		User loggedInUser = userService.getLoggedInUser();
		List<User> friends = friendsService.getAllFriends(loggedInUser);
		model.addAttribute("friendsList", friends);
		
		return "my_friends";
	}
}
