package com.tweetapp.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tweetapp.server.auth.service.UserService;
import com.tweetapp.server.model.User;
import com.tweetapp.server.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public ResponseEntity<?> getUser(String username) {
		User user = userRepository.findById(username).get();
		return ResponseEntity.ok(user);
	}

}
