package com.example.PaymentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PaymentSystem.Repository.UserRepository;
import com.example.PaymentSystem.entity.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	public User getUserById(long id) {
		return userRepo.findById(id).get();
	}
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	public void deleteUser(long id) {
		userRepo.deleteById(id);
	}
}
