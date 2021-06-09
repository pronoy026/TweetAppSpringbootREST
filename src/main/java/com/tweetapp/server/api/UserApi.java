package com.tweetapp.server.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1.0/tweets")
public interface UserApi {
	
	@GetMapping("/getuser/{username}")
	public ResponseEntity<?> getUser(@PathVariable String username);
}
