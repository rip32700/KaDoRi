package com.hsp.kadori.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hsp.kadori.domain.User;

@Repository
public interface UserDao {

	User findUserById(final Long userId);
	List<User> findAllUsers();
	User save(User user);
	User findByEmail(String email);
	User findByUsername(String username);
	
}

