package com.hsp.kadori.domain;

public class Chat {
	
	private Long chatId;
	private User user1;
	private User user2;
	
	public Chat (Long chatId, User user1, User user2) {
		super();
		this.chatId = chatId;
		this.user1 = user1;
		this.user2 = user2;
	}
	
	public Long getChatId() {
		return chatId;
	}
	
	public void setChatId(Long chatId) {
		this.chatId = chatId;
	}
	
	public User getUser1() {
		return user1;
	}
	
	public void setUser1(User user) {
		this.user1 = user;
	}
	
	public User getUser2() {
		return user2;
	}
	
	public void setUser2(User user) {
		this.user2 = user;
	}
}
