package com.sts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sts.entities.User;
import com.sts.repositories.UserRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class FirststsprojectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FirststsprojectApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		//saving single user
//		User user = new User();
//		user.setName("Naman");
//		user.setCity("Noida");
//		userRepository.save(user);

		// to save multiple user, we can create a list/set and pass it to saveAll(list/set) method

		//To Update
		Optional<User> userFound = userRepository.findById(52L);
		User userMatched = userFound.get();
		System.out.println("Before update" + userMatched);
		userMatched.setName("Arun");
		User afterUpdate = userRepository.save(userMatched);
		System.out.println("After update" + afterUpdate);
	}

}
