package com.hsp.kadori.domain;

import java.time.LocalDate;

public class User {

	private String username;
	private int age;
	private LocalDate birthday;
	
	public User(final String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	@Override
	public String toString() {
		return username;
	}
}
