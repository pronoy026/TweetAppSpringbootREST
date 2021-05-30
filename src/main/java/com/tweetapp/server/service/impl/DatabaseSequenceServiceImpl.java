package com.tweetapp.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tweetapp.server.auth.service.DatabaseSequenceService;
import com.tweetapp.server.model.DatabaseSequence;
import com.tweetapp.server.repository.DatabaseSequenceRepository;

@Component
public class DatabaseSequenceServiceImpl implements DatabaseSequenceService{

	@Autowired
	private DatabaseSequenceRepository databaseSequenceRepository;
	
	@Override
	public Long generateNextIdValue(String seqName) {
		
		DatabaseSequence currentSequence = databaseSequenceRepository.findById(seqName).get();
		Long currentSequenceId = currentSequence.getSecValue();
		Long updatedSequenceId = currentSequenceId+1;
		
		currentSequence.setSecValue(updatedSequenceId);
		System.out.println("updated sec id"+updatedSequenceId);
		databaseSequenceRepository.save(currentSequence);
		
		return updatedSequenceId;
	}

}
