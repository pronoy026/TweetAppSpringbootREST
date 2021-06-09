package com.tweetapp.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.tweetapp.server.api.UserApi;
import com.tweetapp.server.service.impl.UserServiceImpl;

@Component
public class UserController implements UserApi {

	@Autowired
	private UserServiceImpl userServiceImpl;
		
	@Override
	public ResponseEntity<?> getUser(String username) {
		return userServiceImpl.getUser(username);
	}

}
