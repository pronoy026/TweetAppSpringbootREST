package com.tweetapp.server.auth.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.tweetapp.server.dto.TweetDto;

@Component
public interface TweetService {
	
	public ResponseEntity<?> postTweet(TweetDto tweetDto, String username);
}
