package com.tweetapp.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.tweetapp.server.api.TweetApi;
import com.tweetapp.server.dto.TweetDto;
import com.tweetapp.server.service.impl.TweetServiceImpl;

@Component
public class TweetController implements TweetApi{
	
	@Autowired
	private TweetServiceImpl tweetServiceImpl;
	
	@Override
	public ResponseEntity<?> login(String username, TweetDto tweetDto) {
		return tweetServiceImpl.postTweet(tweetDto, username);
	}

}
