package com.hsp.kadori.domain;

public class Friendship {
	
	private Long friendshipId;
	private User user1;
	private User user2;

	public Friendship () {
	}
	
	public Friendship (User user1, User user2) {
		super();
		this.user1 = user1;
		this.user2 = user2;
	}
	
	public Friendship (Long friendshipId, User user1, User user2) {
		super();
		this.friendshipId = friendshipId;
		this.user1 = user1;
		this.user2 = user2;
	}
	
	public Long getFriendshipId() {
		return friendshipId;
	}
	
	public void setFriendshipId(Long friendshipId) {
		this.friendshipId = friendshipId;
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
