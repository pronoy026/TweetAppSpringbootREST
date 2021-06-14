package com.tweetapp.server.dto;

public class CommentDto {

	public CommentDto(Long cid, String content, String username, String name, String time) {
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
	
	private String time;

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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}
