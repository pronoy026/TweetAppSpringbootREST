package com.tweetapp.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.tweetapp.server.api.TweetApi;
import com.tweetapp.server.dto.CommentDto;
import com.tweetapp.server.dto.TweetDto;
import com.tweetapp.server.service.impl.TweetServiceImpl;

@Component
public class TweetController implements TweetApi{
	
	@Autowired
	private TweetServiceImpl tweetServiceImpl;
	
	@Override
	public ResponseEntity<?> postTweet(String username, TweetDto tweetDto) {
		return tweetServiceImpl.postTweet(tweetDto, username);
	}

	@Override
	public ResponseEntity<?> updateTweet(String username, String id, TweetDto tweetDto) {
		return tweetServiceImpl.updateTweet(username, id, tweetDto);
	}

	@Override
	public ResponseEntity<?> deleteTweet(String username, String id) {
		return tweetServiceImpl.deleteTweet(username, id);
	}

	@Override
	public ResponseEntity<?> likeTweet(String username, String id) {
		return tweetServiceImpl.likeTweet(username, id);
	}

	@Override
	public ResponseEntity<?> postComment(String username, String id, CommentDto commentDto) {
		return tweetServiceImpl.postComment(username, id, commentDto);
	}

	@Override
	public ResponseEntity<?> getAllTweets() {
		return tweetServiceImpl.getAllTweets();
	}
}
