package com.tweetapp.server.dto;

import com.mongodb.internal.connection.Time;

public class CommentDto {

	public CommentDto(Long cid, String content, String username, String name, Time time) {
		this.cid = cid;
		this.content = content;
		this.username = username;
		this.name = name;
		this.time = time;
	}

	public CommentDto() {
	}

	private Long cid;
	
	private String content;
	
	private String username;
	
	private String name;
	
	private Time time;

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
	
}
