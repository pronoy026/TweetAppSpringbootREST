package com.tweetapp.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tweetapp.server.model.AuthUser;
import com.tweetapp.server.model.User;
import com.tweetapp.server.repository.AuthRepository;
import com.tweetapp.server.repository.UserRepository;

@SpringBootApplication
public class TweetappServerApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthRepository authRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TweetappServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User("prosrkr","Pronoy", "Sarkar", "pronoysarkar16@gmail.com","7872305126");
		userRepository.save(u1);
		
		AuthUser authUser = new AuthUser("ron","ron1");
		authRepository.save(authUser);
		
	}

}
