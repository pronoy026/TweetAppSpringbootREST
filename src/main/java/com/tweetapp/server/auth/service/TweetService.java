package com.tweetapp.server.auth.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.tweetapp.server.dto.CommentDto;
import com.tweetapp.server.dto.TweetDto;

@Component
public interface TweetService {
	
	public ResponseEntity<?> postTweet(TweetDto tweetDto, String username);
	
	public ResponseEntity<?> updateTweet(String username, String id, TweetDto tweetDto);
	
	public ResponseEntity<?> deleteTweet(String username, String id);
	
	public ResponseEntity<?> likeTweet(String username, String id);
	
	public ResponseEntity<?> postComment(String username, String id, CommentDto commentDto);
}
