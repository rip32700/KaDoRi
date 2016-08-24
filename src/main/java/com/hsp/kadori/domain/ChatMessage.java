package com.hsp.kadori.domain;

import java.util.Date;

public class ChatMessage {
	
	private Long chatMessageId;
	private String content;
	private Date messageTime;
	private Chat chat;
	private User user;

	public ChatMessage (Long chatMessageId, String content, Date messageTime, Chat chat, User user) {
		super();
		this.chatMessageId = chatMessageId;
		this.content = content;
		this.messageTime = messageTime;
		this.chat = chat;
		this.user = user;
	}
	
	public Long getChatMessageId() {
		return chatMessageId;
	}
	
	public void setChatMessageId(Long chatMessageId) {
		this.chatMessageId = chatMessageId;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCreationTime() {
		return messageTime;
	}
	
	public void setCreationTime(Date messageTime) {
		this.messageTime = messageTime;
	}
	
	public Chat getChat() {
		return chat;
	}
	
	public void setChat(Chat chat) {
		this.chat = chat;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
