package com.tweetapp.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.server.model.Tweet;
import com.tweetapp.server.repository.TweetRepository;

@RestController
public class SampleController {
	
	@Autowired
	TweetRepository tweetRepository;
	
	@GetMapping("/sample")
	public String sample() {
		return "Sample Access!";
	}
	
	@PostMapping("/{id}")
	public Tweet checker(@PathVariable String id) {
		Tweet t = tweetRepository.findById(id).get();
		return t;
	}
}
