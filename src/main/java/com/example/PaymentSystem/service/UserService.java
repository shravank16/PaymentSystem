package com.example.PaymentSystem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PaymentSystem.Repository.UserRepository;
import com.example.PaymentSystem.entity.User;

@Service
public class UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepository userRepo;
	
	public List<User> getAllUsers() {
		log.info("get all users");
		return userRepo.findAll();
	}
	
	public User getUserById(long id) {
		log.info("get user by id");
		return userRepo.findById(id).get();
	}
	
	public User createUser(User user) {
		log.info("created user");
		return userRepo.save(user);
	}
	
	public void deleteUser(long id) {
		log.info("deleted user");
		userRepo.deleteById(id);
	}
}
