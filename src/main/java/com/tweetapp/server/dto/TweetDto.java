package com.tweetapp.server.dto;

import org.springframework.data.annotation.Id;

import com.mongodb.internal.connection.Time;

public class TweetDto {

	public TweetDto() {
	}
	
	public TweetDto(Long tid, String content, String like, String commentCount, Time time, String username) {
		this.tid = tid;
		this.content = content;
		this.like = like;
		this.commentCount = commentCount;
		this.time = time;
		this.username = username;
	}

	@Id
	private Long tid;
	
	private String content;
	
	private String like;
	
	private String commentCount;
	
	private Time time;
	
	private String username;

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}

	public String getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
