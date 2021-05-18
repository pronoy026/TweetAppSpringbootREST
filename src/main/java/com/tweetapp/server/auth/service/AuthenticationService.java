package com.tweetapp.server.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.tweetapp.server.auth.model.AuthLoginRequest;
import com.tweetapp.server.auth.model.AuthResponse;
import com.tweetapp.server.auth.util.JwtUtil;
import com.tweetapp.server.dto.UserDto;
import com.tweetapp.server.model.AuthUser;
import com.tweetapp.server.model.User;
import com.tweetapp.server.repository.AuthRepository;
import com.tweetapp.server.repository.UserRepository;

@Service
public class AuthenticationService {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthRepository authRepository;

	private String createAuthToken(AuthUser authUser) {
		try {
			//Spring security default authentication attempt
			Authentication authentication = new UsernamePasswordAuthenticationToken(authUser.getUsername(), authUser.getPassword());
			authenticationManager.authenticate(authentication);
			
		} catch (BadCredentialsException e) {
			throw e;
		}
	
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authUser.getUsername());
		
		//token generation
		final String jwtToken = jwtUtil.generateToken(userDetails);
		
		return jwtToken;
	}
	
	public ResponseEntity<?> loginUser(AuthLoginRequest authRequest) {
		AuthUser authUser = new AuthUser(authRequest.getUsername(), authRequest.getPassword());
		try {
			String token = createAuthToken(authUser);
			AuthResponse response = new AuthResponse(token);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Username or Password is incorrect!");
		}
	}
	
	public ResponseEntity<?> registerUser(UserDto userDto) {
		
		Boolean usernameExists;
		Boolean emailExists;
		String token;
		
		usernameExists = userRepository.findById(userDto.getUsername()).isPresent();
		emailExists = !userRepository.findByEmail(userDto.getEmail()).isEmpty();
		
		if(usernameExists) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("username already exists!");
		}
		
		if(emailExists) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("email already exists!");
		}
		
		AuthUser authUser = new AuthUser(userDto.getUsername(), userDto.getPassword());
		authRepository.save(authUser);
		
		User user = new User(userDto.getUsername(), userDto.getFirstname(), userDto.getLastname(),
				userDto.getEmail(), userDto.getPhone());
		userRepository.save(user);
		
		token = createAuthToken(authUser);
		AuthResponse response = new AuthResponse(token);
		return ResponseEntity.ok(response);	
	}
}
