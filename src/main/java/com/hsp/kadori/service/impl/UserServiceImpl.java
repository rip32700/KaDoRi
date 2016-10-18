package com.hsp.kadori.service.impl;


import java.util.List;

import javax.inject.Inject;

import com.hsp.kadori.dao.UserDao;
import com.hsp.kadori.domain.Group;
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
	
	@Override
	public User updateUserAccount(UserDTO userDto) {
		User user = repository.findUserById(userDto.getUserId());
		
		if (!user.getEmail().equals(userDto.getEmail()) && emailExists(userDto.getEmail())) {   
            throw new EmailExistsException("There is an account with that email address: "+ user.getEmail());
        }
		
		if (!user.getUsername().equals(userDto.getUsername()) && usernameExists(userDto.getUsername())) {   
            throw new UsernameExistsException("There is an account with that username address: "+ user.getUsername());
        }
		
		user.setFirstname(userDto.getFirstName());
		user.setLastname(userDto.getLastName());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		user.setStreet(userDto.getStreet());
		user.setStreetNumber(userDto.getStreetNumber());
        user.setCity(userDto.getCity());
        user.setZip(userDto.getZip());
        user.setType(userDto.getType());
        user.setBirthday(userDto.getBirthday());
        
        return repository.save(user);
	}
	
	@Override
	public void deleteUserAccount(Long userId) {
		repository.delete(userId);
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
	
	@Override
	public List<Group> getGroups(User user) {
		List<Group> groups = repository.getGroups(user.getUserId());
		
		return groups;
	}

	@Override
	public User getUserById(long userId) {
		return repository.findUserById(userId);
	}

	@Override
	public User getUserByName(String userName) {
		return repository.findByUsername(userName);
	}

	@Override
	public List<User> getAvailableFriends(User me) {
		return repository.findAvailableFriends(me);
	}

	@Override
	public List<Group> getAvailableGroups(User me) {
		return repository.getJoinableGroups(me);
	}

}
