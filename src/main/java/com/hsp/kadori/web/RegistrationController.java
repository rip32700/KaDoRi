package com.hsp.kadori.web;

import javax.inject.Inject;
import javax.servlet.ServletException;
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

import com.hsp.kadori.domain.User;
import com.hsp.kadori.dto.UserDTO;
import com.hsp.kadori.exceptions.EmailExistsException;
import com.hsp.kadori.service.UserService;

@Controller
public class RegistrationController {
	@Inject 
	private UserService service;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegistrationForm(final Model model) {
		model.addAttribute("userDTO", new UserDTO());
		return "registration";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("userDTO") @Valid final UserDTO user, final BindingResult result, final Errors errors, final HttpServletRequest request) {
		User registered = new User();
		
		if (!result.hasErrors()) {
	        registered = createUserAccount(user, result);
	    }
	    if (result.hasErrors()) {
	        return new ModelAndView("registration", "userDTO", user);
	    } 
	    else {
	    	// auto login after successful registraiton
	    	try {
				request.login(registered.getUsername(),registered.getPassword());
			} catch (ServletException e) {
				e.printStackTrace();
			}
	        return new ModelAndView("registrationSuccess", "userDTO", user);
	    }
	}

	private User createUserAccount(UserDTO user, BindingResult result) {
		User registered = null;
	    try {
	        registered = service.registerNewUserAccount(user);
	    } catch (EmailExistsException e) {
	        return null;
	    }
	    return registered;
	}
	
}
