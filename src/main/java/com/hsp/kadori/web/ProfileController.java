package com.hsp.kadori.web;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hsp.kadori.dao.UserDao;
import com.hsp.kadori.domain.User;
import com.hsp.kadori.dto.UserDTO;
import com.hsp.kadori.service.UserService;
import com.hsp.kadori.service.utils.UserUtils;

@Controller
public class ProfileController {
	
	@Inject 
	private UserService service;
	
	@Inject
	UserDao userRepository;
	
	@RequestMapping(value="/my_profile")
	public ModelAndView loadProfilePage(final Model model) {
		String userName = UserUtils.getCurrentUserName();
		User user = userRepository.findByUsername(userName);
		if (user.getEmail().equals("anonymousUser@ADManonymousUser.de")) {
			return new ModelAndView("redirect:/register");
		}
		
		model.addAttribute("currentUser", user);
		
		return new ModelAndView("my_profile");
	}
	
	@RequestMapping(value="/edit_profile", method=RequestMethod.GET)
	public ModelAndView showEditProfileForm(final Model model) {
		String userName = UserUtils.getCurrentUserName();
		User user = userRepository.findByUsername(userName);
		if (user.getEmail().equals("anonymousUser@ADManonymousUser.de")) {
			return new ModelAndView("redirect:/register");
		}

		model.addAttribute("userDTO", new UserDTO(user.getUserId(), user.getFirstname(), user.getLastname(), user.getUsername(), user.getEmail(), user.getPassword(), user.getPassword(), user.getType(), user.getBirthday(), user.getStreet(), user.getStreetNumber(), user.getCity(), user.getZip()));
		return new ModelAndView("edit_profile");
	}
	
	@RequestMapping(value="/edit_profile", method=RequestMethod.POST)
	public ModelAndView editProfile(@ModelAttribute("userDTO") @Valid final UserDTO user, final BindingResult result, final Errors errors, final HttpServletRequest request) {
		if (result.hasErrors()) {
	        return new ModelAndView("edit_profile", "userDTO", user);
	    }
		
		User updatedUser = service.updateUserAccount(user);
		return new ModelAndView("my_profile", "currentUser", updatedUser);
	}
}
