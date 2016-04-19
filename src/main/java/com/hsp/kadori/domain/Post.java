package com.hsp.kadori.domain;

import java.time.LocalDate;

public class Post {

	private User author;
	private LocalDate creationDate;
	private LocalDate lastModified;
	private String title;
	private String message;
	
	public Post() {
		
	}
	
	public Post(User author, LocalDate creationDate, LocalDate lastModified, String title, String message) {
		super();
		this.author = author;
		this.creationDate = creationDate;
		this.lastModified = lastModified;
		this.title = title;
		this.message = message;
	}
	
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDate getLastModified() {
		return lastModified;
	}
	public void setLastModified(LocalDate lastModified) {
		this.lastModified = lastModified;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
