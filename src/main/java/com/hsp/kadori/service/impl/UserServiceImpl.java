package com.hsp.kadori.service.impl;


import javax.inject.Inject;

import com.hsp.kadori.dao.UserDao;
import com.hsp.kadori.domain.User;
import com.hsp.kadori.dto.UserDTO;
import com.hsp.kadori.exceptions.EmailExistsException;
import com.hsp.kadori.exceptions.UsernameExistsException;
import com.hsp.kadori.service.UserService;
import com.hsp.kadori.service.utils.UserUtils;

public class UserServiceImpl implements UserService {

	@Inject
	private UserDao repository;
	
	@Override
	public User registerNewUserAccount(UserDTO user) {

		if (emailExists(user.getEmail())) {   
            throw new EmailExistsException("There is an account with that email address: "+ user.getEmail());
        }
		
		if (usernameExists(user.getUsername())) {   
            throw new UsernameExistsException("There is an account with that username address: "+ user.getUsername());
        }
		
        User newUser = new User();    
        newUser.setFirstname(user.getFirstName());
        newUser.setLastname(user.getLastName());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setStreet(user.getStreet());
        newUser.setStreetNumber(user.getStreetNumber());
        newUser.setCity(user.getCity());
        newUser.setZip(user.getZip());
        newUser.setType(user.getType());
        newUser.setBirthday(user.getBirthday());
        newUser.setRole(2); /*ROLE_USER*/
        
        return repository.save(newUser); 
	}

	private boolean emailExists(String email) {
		User user = repository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
	}
	
	private boolean usernameExists(String username) {
		User user = repository.findByUsername(username);
        if (user != null) {
            return true;
        }
        return false;
	}

	@Override
	public User getLoggedInUser() {
		String currentUserName = UserUtils.getCurrentUserName();
		return repository.findByUsername(currentUserName);
	}

}
