package com.hsp.kadori.domain;
import java.util.Date;

public class Group {
	
	private Long groupId;
	private Date date;
	private String groupDescription;
	private String groupName;
	
	public Group() {
		
	}
	
	public Group (Date date, String description, String name) {
		super();
		this.date = date;
		this.groupDescription = description;
		this.groupName = name;
	}
	
	public Group (Long groupId, Date date, String description, String name) {
		super();
		this.groupId = groupId;
		this.date = date;
		this.groupDescription = description;
		this.groupName = name;
	}
	
	public Long getGroupId() {
		return groupId;
	}
	
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getGroupDescription() {
		return groupDescription;
	}
	
	public void setGroupDescription(String description) {
		this.groupDescription = description;
	}
	
	public String getGroupName() {
		return groupName;
	}
	
	public void setGroupName(String name) {
		this.groupName = name;
	}
}
