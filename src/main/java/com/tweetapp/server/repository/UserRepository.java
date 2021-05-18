package com.tweetapp.server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tweetapp.server.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	List<User> findByEmail(String email);
}
