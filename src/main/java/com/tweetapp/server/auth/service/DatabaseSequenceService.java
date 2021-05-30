package com.tweetapp.server.auth.service;

import org.springframework.stereotype.Component;

@Component
public interface DatabaseSequenceService {
	public Long generateNextIdValue(String seqName);
}
