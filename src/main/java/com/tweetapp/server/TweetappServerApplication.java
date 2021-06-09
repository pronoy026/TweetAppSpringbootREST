package com.tweetapp.server;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tweetapp.server.model.AuthUser;
import com.tweetapp.server.model.Comment;
import com.tweetapp.server.model.DatabaseSequence;
import com.tweetapp.server.model.Tweet;
import com.tweetapp.server.model.User;
import com.tweetapp.server.repository.AuthRepository;
import com.tweetapp.server.repository.DatabaseSequenceRepository;
import com.tweetapp.server.repository.TweetRepository;
import com.tweetapp.server.repository.UserRepository;

@SpringBootApplication
public class TweetappServerApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthRepository authRepository;
	
	@Autowired
	private DatabaseSequenceRepository databaseSequenceRepository;
	
	@Autowired
	private TweetRepository tweetRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TweetappServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User("prosrkr","Pronoy", "Sarkar", "pronoysarkar16@gmail.com","7872305126");
		userRepository.save(u1);
		
		AuthUser authUser = new AuthUser("ron","ron1");
		authRepository.save(authUser);
		
		Optional<DatabaseSequence> tdatabaseSequence = databaseSequenceRepository.findById("TweetSequence");
		
		if(tdatabaseSequence.isPresent()) {
			if(tdatabaseSequence.get().getSecValue()>0) {
			// getting the max tid value from Tweet collection and updating
			Long maxIdValue = tweetRepository.findAll().stream().max(Comparator.comparing(Tweet::getTid)).get().getTid();
			DatabaseSequence databaseSequence = databaseSequenceRepository.findById("TweetSequence").get();
			databaseSequence.setSecValue(maxIdValue);
			databaseSequenceRepository.save(databaseSequence);
			}
			else {
				DatabaseSequence databaseSequence = new DatabaseSequence("TweetSequence", new Long(0));
				databaseSequenceRepository.save(databaseSequence);
			}	
		} else {
			DatabaseSequence databaseSequence = new DatabaseSequence("TweetSequence", new Long(0));
			databaseSequenceRepository.save(databaseSequence);
		}
		
		Optional<DatabaseSequence> cdatabaseSequence = databaseSequenceRepository.findById("CommentSequence");
		
		if(cdatabaseSequence.isPresent()) {
			if(cdatabaseSequence.get().getSecValue()>0) {
			// getting the max tid value from Tweet collection's Comments List and updating
			List<List<Comment>> list1= tweetRepository.findAll().stream().map(Tweet::getComments).collect(Collectors.toList());
			
			List<Comment> list2 = new ArrayList<Comment>();
			list1.stream().forEach(cList-> {
				cList.forEach(c-> list2.add(c));
			});
			
			Long maxIdValue = list2.stream().max(Comparator.comparing(Comment::getCid)).get().getCid();
			
			DatabaseSequence databaseSequence = databaseSequenceRepository.findById("TweetSequence").get();
			databaseSequence.setSecValue(maxIdValue);
			databaseSequenceRepository.save(databaseSequence);
			}
			else {
				DatabaseSequence databaseSequence = new DatabaseSequence("CommentSequence", new Long(0));
				databaseSequenceRepository.save(databaseSequence);
			}
		} else {
			DatabaseSequence databaseSequence = new DatabaseSequence("CommentSequence", new Long(0));
			databaseSequenceRepository.save(databaseSequence);
		}

	}

}
