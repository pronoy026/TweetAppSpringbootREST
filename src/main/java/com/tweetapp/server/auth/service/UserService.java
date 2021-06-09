package com.tweetapp.server.auth.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public interface UserService {
	
	public ResponseEntity<?> getUser(@PathVariable String username);
}
