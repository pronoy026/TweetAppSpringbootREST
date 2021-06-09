package com.tweetapp.server.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.server.dto.CommentDto;
import com.tweetapp.server.dto.TweetDto;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1.0/tweets")
public interface TweetApi {
	
	@PostMapping("/{username}/add")
	public ResponseEntity<?> postTweet(@PathVariable String username, @RequestBody TweetDto tweetDto);
	
	@PutMapping("/{username}/update/{id}")
	public ResponseEntity<?> updateTweet(@PathVariable String username, @PathVariable String id, @RequestBody TweetDto tweetDto);
	
	@DeleteMapping("/{username}/update/{id}")
	public ResponseEntity<?> deleteTweet(@PathVariable String username, @PathVariable String id);
	
	@PutMapping("/{username}/like/{id}")
	public ResponseEntity<?> likeTweet(@PathVariable String username, @PathVariable String id);
	
	@PostMapping("/{username}/reply/{id}")
	public ResponseEntity<?> postComment(@PathVariable String username, @PathVariable String id, @RequestBody CommentDto commentDto);
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllTweets();
	
	
}
