package com.tweetapp.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tweetapp.server.model.AuthUser;

public interface AuthRepository extends MongoRepository<AuthUser, String> {
	
}
