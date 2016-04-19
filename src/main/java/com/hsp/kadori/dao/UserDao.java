package com.hsp.kadori.dao;

import org.springframework.stereotype.Repository;

import com.hsp.kadori.domain.User;

@Repository
public interface UserDao {

	User findUserById(final Long userId);
}
