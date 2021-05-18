package com.tweetapp.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.tweetapp.server.api.AuthenticationApi;
import com.tweetapp.server.auth.model.AuthLoginRequest;
import com.tweetapp.server.auth.service.AuthenticationService;
import com.tweetapp.server.dto.UserDto;

@Component
public class AuthenticationController implements AuthenticationApi{

	@Autowired
	AuthenticationService authenticatinService;
	
	@Override
	public ResponseEntity<?> login(AuthLoginRequest authRequest) {
		ResponseEntity<?> response = authenticatinService.loginUser(authRequest);
		return response;
	}

	@Override
	public ResponseEntity<?> register(UserDto userDto) {
		ResponseEntity<?> response = authenticatinService.registerUser(userDto);
		return response;
	}

}
