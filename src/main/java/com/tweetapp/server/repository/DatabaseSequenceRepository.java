package com.tweetapp.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tweetapp.server.model.DatabaseSequence;

public interface DatabaseSequenceRepository extends MongoRepository<DatabaseSequence, String>{

}
