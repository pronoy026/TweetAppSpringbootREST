package com.tweetapp.server.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.server.auth.model.AuthLoginRequest;
import com.tweetapp.server.dto.UserDto;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0/tweets")
@RestController
public interface AuthenticationApi {

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthLoginRequest authRequest);
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UserDto authRequest);
}
