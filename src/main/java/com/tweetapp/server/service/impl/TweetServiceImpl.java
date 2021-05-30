package com.tweetapp.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tweetapp.server.auth.service.TweetService;
import com.tweetapp.server.dto.TweetDto;
import com.tweetapp.server.model.Tweet;
import com.tweetapp.server.repository.TweetRepository;

@Service
public class TweetServiceImpl implements TweetService{

	@Autowired
	private TweetRepository tweetRepository;
	
	@Autowired
	private DatabaseSequenceServiceImpl databaseSequenceServiceImpl;
	
	@Override
	public ResponseEntity<?> postTweet(TweetDto tweetDto, String username) {
		Tweet tweet = new Tweet();
		tweet.setTid(databaseSequenceServiceImpl.generateNextIdValue("TweetSequence"));
		tweet.setContent(tweetDto.getContent());
		tweet.setLike(tweetDto.getLike());
		tweet.setCommentCount(tweetDto.getCommentCount());
		tweet.setTime(tweetDto.getTime());
		tweet.setUsername(username);
		
		tweetRepository.save(tweet);
		return ResponseEntity.status(HttpStatus.CREATED).body("Tweet posted succsessfully!");
	}

}
