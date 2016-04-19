package com.hsp.kadori.dao.impl;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcOperations;

import com.hsp.kadori.dao.UserDao;
import com.hsp.kadori.domain.User;

public class UserDaoImpl implements UserDao {

	@Inject
	JdbcOperations jdbcOperations;
	
	@Override
	public User findUserById(Long userId) {
		return null; //jdbcOperations.query(null, null, null);
	}

}
