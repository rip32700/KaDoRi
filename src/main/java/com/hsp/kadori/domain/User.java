package com.hsp.kadori.domain;


public class User {

	private Long userId;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String birthday;
	private String street;
	private String streetNumber;
	private String city;
	private String zip;
	private String type;
	private int role;
	
	public User() {
		
	}

	public User(Long userId, String username, String firstname, String lastname, String email, String password,
			String birthday, String street, String streetNumber, String city, String zip, String type, int role) {
		super();
		this.userId = userId;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.zip = zip;
		this.type = type;
		this.role = role;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof User) {
			User otherUser = (User) other;
			if(otherUser.userId == this.userId) {
				return true;
			} else {
				return false;
			}
		} else {
			return super.equals(other);
		}
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
}
