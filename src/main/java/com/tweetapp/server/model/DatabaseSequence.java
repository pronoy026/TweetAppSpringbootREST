package com.tweetapp.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DBsequence")
public class DatabaseSequence {
	
	public DatabaseSequence() {
	}
	
	public DatabaseSequence(String seqName, Long secValue) {
		this.seqName = seqName;
		this.secValue = secValue;
	}

	@Id
	public String seqName;
	
	public Long secValue;

	public String getSeqName() {
		return seqName;
	}

	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}

	public Long getSecValue() {
		return secValue;
	}

	public void setSecValue(Long secValue) {
		this.secValue = secValue;
	}
}
