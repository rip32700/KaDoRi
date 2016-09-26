package com.hsp.kadori.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hsp.kadori.domain.User;
import com.hsp.kadori.dto.UserDTO;
import com.hsp.kadori.service.FriendsService;
import com.hsp.kadori.service.UserService;

@Controller
public class ProfileController {
	
	@Inject
	FriendsService friendsService;
	
	@Inject 
	private UserService userService;
	
	@RequestMapping(value="/profile/my_profile")
	public ModelAndView loadProfilePage(final Model model) {
		User user = userService.getLoggedInUser();
		if (user.getEmail().equals("anonymousUser@ADManonymousUser.de")) {
			return new ModelAndView("redirect:/register");
		}
		
		model.addAttribute("currentUser", user);
		model.addAttribute("user", user);
		
		return new ModelAndView("profile");
	}
	
	@RequestMapping(value="/profile/{username}")
	public ModelAndView loadProfilePage(final Model model, @PathVariable("username") String userName) {
		User user = userService.getUserByName(userName);
		User currentUser = userService.getLoggedInUser();
		List<User> allFriends = friendsService.getAllFriends(currentUser);
		boolean isFriend = false;
		if(allFriends.contains(user)) {
			isFriend = true;
		}
		
		if(user == null) {
			return new ModelAndView("redirect:/");
		}
		
		if (user.getEmail().equals("anonymousUser@ADManonymousUser.de")) {
			return new ModelAndView("redirect:/register");
		}
		
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("user", user);
		model.addAttribute("isFriend", isFriend);
		
		return new ModelAndView("profile");
	}
	
	@RequestMapping(value="/profile/edit_profile", method=RequestMethod.GET)
	public ModelAndView showEditProfileForm(final Model model) {
		User user = userService.getLoggedInUser();
		if (user.getEmail().equals("anonymousUser@ADManonymousUser.de")) {
			return new ModelAndView("redirect:/register");
		}

		model.addAttribute("userDTO", new UserDTO(user.getUserId(), user.getFirstname(), user.getLastname(), user.getUsername(), user.getEmail(), user.getPassword(), user.getPassword(), user.getType(), user.getBirthday(), user.getStreet(), user.getStreetNumber(), user.getCity(), user.getZip()));
		return new ModelAndView("edit_profile");
	}
	
	@RequestMapping(value="/profile/edit_profile", method=RequestMethod.POST)
	public ModelAndView editProfile(@ModelAttribute("userDTO") @Valid final UserDTO user, final BindingResult result, final Errors errors, final HttpServletRequest request) {
		if (result.hasErrors()) {
	        return new ModelAndView("edit_profile", "userDTO", user);
	    }

		return new ModelAndView("redirect:/profile/my_profile");
	}
	
	@RequestMapping(value="/profile/{username}/add_friend")
	public ModelAndView addAsFriend(Model model, @PathVariable("username") String userName) {
		User loggedInUser = userService.getLoggedInUser();
		User otherUser = userService.getUserByName(userName);
		
		List<User> allFriends = friendsService.getAllFriends(loggedInUser);
		if(allFriends.contains(otherUser)) {
			//Error: already friends -> no new friendship should be added
			//TODO Error-Handling
			return new ModelAndView("home");
		}
		friendsService.addFriendship(loggedInUser, otherUser);
		
		return new ModelAndView("friendshipSuccess");
	}
	
	@RequestMapping(value="/profile/{username}/add_friend/friendshipSuccess")
	public ModelAndView addAsFriendSuccess(Model model, @PathVariable("username") String username) {
		model.addAttribute("username", username);
		return new ModelAndView("friendshipSuccess");
	}
	
	@RequestMapping(value="/profile/{username}/remove_friend")
	public ModelAndView removeAsFriend(Model model, @PathVariable("username") String userName) {
		User loggedInUser = userService.getLoggedInUser();
		User otherUser = userService.getUserByName(userName);
		
		friendsService.removeFriendship(loggedInUser, otherUser);
		
		return new ModelAndView("redirect:/my_friends");
	}
}
