package com.hsp.kadori.service;

import org.springframework.stereotype.Service;

import com.hsp.kadori.domain.User;
import com.hsp.kadori.dto.UserDTO;

@Service
public interface UserService {

	User registerNewUserAccount(final UserDTO user);
	User updateUserAccount(final UserDTO user);
	User getLoggedInUser();
	
}
