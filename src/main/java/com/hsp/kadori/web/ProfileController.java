package com.hsp.kadori.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsp.kadori.dao.UserDao;
import com.hsp.kadori.domain.User;
import com.hsp.kadori.web.utils.UserUtils;

@Controller
public class ProfileController {
	
	
	@Inject
	UserDao userRepository;
	
	@RequestMapping(value="/my_profile")
	public String loadProfilePage(final Model model) {
		String userName = UserUtils.getCurrentUserName();
		User user = userRepository.findByUsername(userName);
		
		model.addAttribute("currentUser", user);
		
		return "my_profile";
	}
	
	
}
