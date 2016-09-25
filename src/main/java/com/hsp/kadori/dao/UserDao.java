package com.hsp.kadori.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hsp.kadori.domain.Group;
import com.hsp.kadori.domain.User;

@Repository
public interface UserDao {

	User findUserById(final Long userId);
	List<User> findAllUsers();
	List<User> findAllFriends(final long userId);
	User save(User user);
	User findByEmail(String email);
	User findByUsername(String username);
	List<Group> getGroups(final long userId);
	List<Group> getJoinableGroups(User me);
	List<User> findAvailableFriends(User me);
}

