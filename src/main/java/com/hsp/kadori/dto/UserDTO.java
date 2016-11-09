package com.hsp.kadori.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.hsp.kadori.domain.User;

public class UserDTO {

	private Long userId;
	
	@NotNull
	@NotEmpty
	private String firstName;
	
	@NotNull
	@NotEmpty
	private String lastName;
	
	@NotNull
	@NotEmpty
	private String username;
	
	@NotNull
	@NotEmpty
	private String email;
	
	@NotNull
	@NotEmpty
	private String password;
	
	@NotNull
	@NotEmpty
	private String matchingPassword;
	
	@NotNull
	@NotEmpty
	private String type;
	
	@NotNull
	@NotEmpty
	private String birthday;
	
	@NotNull
	@NotEmpty
	private String street;
	
	private String streetNumber;
	
	@NotNull
	@NotEmpty
	private String city;
	
	private String zip;
	
	public UserDTO() {
	}
	
	public UserDTO(String firstName, String lastName, String username, String email, String password,
			String matchingPassword, String type, String birthday, String street, String streetNumber, String city,
			String zip) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.matchingPassword = matchingPassword;
		this.type = type;
		this.birthday = birthday;
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.zip = zip;
	}
	
	public UserDTO(User user) {
		super();
		this.userId = user.getUserId();
		this.firstName = user.getFirstname();
		this.lastName = user.getLastname();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.matchingPassword = user.getPassword();
		this.type = user.getType();
		this.birthday = user.getBirthday();
		this.street = user.getStreet();
		this.streetNumber = user.getStreetNumber();
		this.city = user.getCity();
		this.zip = user.getZip();
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getMatchingPassword() {
		return matchingPassword;
	}
	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	
	public Long getUserId() {
		return this.userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
