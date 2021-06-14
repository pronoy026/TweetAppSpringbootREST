package com.tweetapp.server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tweetapp.server.model.Tweet;

public interface TweetRepository extends MongoRepository<Tweet, String>{
	
	List<Tweet> findByTid(String tid);
}
