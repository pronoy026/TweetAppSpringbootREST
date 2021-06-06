package com.tweetapp.server.dto;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.mongodb.internal.connection.Time;
import com.tweetapp.server.model.Comment;

public class TweetDto {

	public TweetDto() {
	}

	public TweetDto(Long tid, String content, Long like, Long commentCount, Time time, String username,
			List<Comment> comments) {
		this.tid = tid;
		this.content = content;
		this.like = like;
		this.commentCount = commentCount;
		this.time = time;
		this.username = username;
		this.comments = comments;
	}

	@Id
	private Long tid;
	
	private String content;
	
	private Long like;
	
	private Long commentCount;
	
	private Time time;
	
	private String username;
	
	private List<Comment> comments;

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

	public Long getLike() {
		return like;
	}

	public void setLike(Long like) {
		this.like = like;
	}

	public Long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Long commentCount) {
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
