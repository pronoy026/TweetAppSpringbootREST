package com.tweetapp.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tweetapp.server.auth.service.TweetService;
import com.tweetapp.server.dto.CommentDto;
import com.tweetapp.server.dto.TweetDto;
import com.tweetapp.server.model.Comment;
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
		return ResponseEntity.status(HttpStatus.CREATED).body(tweet);
	}

	@Override
	public ResponseEntity<?> updateTweet(String username, String id, TweetDto tweetDto) {
		Tweet tweet = tweetRepository.findById(id).get();
		tweet.setContent(tweetDto.getContent());
		tweetRepository.save(tweet);
		return ResponseEntity.status(HttpStatus.OK).body("Tweet edited succsessfully!");
	}

	@Override
	public ResponseEntity<?> deleteTweet(String username, String id) {
		tweetRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Tweet deleted succsessfully!");
	}

	@Override
	public ResponseEntity<?> likeTweet(String username, String id) {
		Tweet tweet = tweetRepository.findById(id).get();
		Long updatedLikes = tweet.getLike();
		updatedLikes+=1;
		tweet.setLike(updatedLikes);
		tweetRepository.save(tweet);
		return ResponseEntity.status(HttpStatus.OK).body("Tweet liked succsessfully!");
	}

	@Override
	public ResponseEntity<?> postComment(String username, String id, CommentDto commentDto) {
		Tweet tweet = tweetRepository.findById(id).get();
		Comment comment = new Comment();
		comment.setCid(databaseSequenceServiceImpl.generateNextIdValue("CommentSequence"));
		comment.setContent(commentDto.getContent());
		comment.setTime(commentDto.getTime());
		comment.setUsername(commentDto.getUsername());
		comment.setName(commentDto.getName());
		tweet.getComments().add(comment);
		tweetRepository.save(tweet);
		return ResponseEntity.status(HttpStatus.OK).body("Comment posted successfully!");
	}

	@Override
	public ResponseEntity<?> getAllTweets() {
		List<Tweet> alltweets = tweetRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(alltweets);
	}

}
