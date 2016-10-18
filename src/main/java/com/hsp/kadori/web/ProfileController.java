package com.hsp.kadori.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
		User loggedInUser = userService.getLoggedInUser();
		if (loggedInUser.getEmail().equals("anonymousUser@ADManonymousUser.de")) {
			return new ModelAndView("redirect:/login");
		}
		
		model.addAttribute("currentUser", loggedInUser);
		model.addAttribute("user", loggedInUser);
		
		return new ModelAndView("profile");
	}
	
	@RequestMapping(value="/profile/{username}")
	public ModelAndView loadProfilePage(final Model model, @PathVariable("username") String userName) {
		User profileUser = userService.getUserByName(userName);
		User loggedInUser = userService.getLoggedInUser();
		if (loggedInUser.getEmail().equals("anonymousUser@ADManonymousUser.de")) {
			return new ModelAndView("redirect:/login");
		}
		
		List<User> allFriends = friendsService.getAllFriends(loggedInUser);
		boolean isFriend = false;
		if(allFriends.contains(profileUser)) {
			isFriend = true;
		}

		model.addAttribute("currentUser", loggedInUser);
		model.addAttribute("user", profileUser);
		model.addAttribute("isFriend", isFriend);
		
		return new ModelAndView("profile");
	}
	
	@RequestMapping(value="/profile/edit_profile", method=RequestMethod.GET)
	public ModelAndView showEditProfileForm(final Model model) {
		User loggedInUser = userService.getLoggedInUser();
		if (loggedInUser.getEmail().equals("anonymousUser@ADManonymousUser.de")) {
			return new ModelAndView("redirect:/login");
		}

		model.addAttribute("userDTO", new UserDTO(loggedInUser));
		return new ModelAndView("edit_profile");
	}
	
	@RequestMapping(value="/profile/edit_profile", method=RequestMethod.POST)
	public ModelAndView editProfile(@ModelAttribute("userDTO") @Valid final UserDTO user, final BindingResult result, final Errors errors, final HttpServletRequest request) {
		if (result.hasErrors()) {
	        return new ModelAndView("edit_profile", "userDTO", user);
	    }
		
		userService.updateUserAccount(user);
		return new ModelAndView("redirect:/profile/my_profile");
	}
	
	@RequestMapping(value="/profile/my_profile/delete")
	public ModelAndView deleteProfile(Model model, HttpServletRequest request, HttpServletResponse response) {
		User loggedInUser = userService.getLoggedInUser();
		userService.deleteUserAccount(loggedInUser.getUserId());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/profile/{username}/add_friend")
	public ModelAndView addAsFriend(Model model, @PathVariable("username") String userName) {
		User loggedInUser = userService.getLoggedInUser();
		if (loggedInUser.getEmail().equals("anonymousUser@ADManonymousUser.de")) {
			return new ModelAndView("redirect:/login");
		}
		
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
		if (loggedInUser.getEmail().equals("anonymousUser@ADManonymousUser.de")) {
			return new ModelAndView("redirect:/login");
		}
		
		User otherUser = userService.getUserByName(userName);
		friendsService.removeFriendship(loggedInUser, otherUser);
		
		return new ModelAndView("redirect:/my_friends");
	}
}
