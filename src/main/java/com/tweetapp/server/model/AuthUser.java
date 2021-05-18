package com.tweetapp.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Auth")
public class AuthUser {
	
	public AuthUser() {
	}
	
	public AuthUser(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Id
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
