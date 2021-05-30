package com.tweetapp.server.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.server.dto.TweetDto;

@RestController
@RequestMapping("/api/v1.0/tweets")
public interface TweetApi {
	
	@PostMapping("/{username}/add")
	public ResponseEntity<?> login(@PathVariable String username, @RequestBody TweetDto authRequest);
}
