package com.tweetapp.server.auth.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tweetapp.server.model.AuthUser;
import com.tweetapp.server.repository.AuthRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	AuthRepository authRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//validates the user from database
		AuthUser user = authRepository.findById(username).get();
		//returns the user to Auth Manager
		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}
}
