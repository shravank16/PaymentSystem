package com.example.PaymentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PaymentSystem.Repository.AccountRepository;
import com.example.PaymentSystem.Repository.UserRepository;
import com.example.PaymentSystem.entity.Account;
import com.example.PaymentSystem.entity.User;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public List<Account> getAllAccounts(){
		return accountRepo.findAll();
	}
	
	public void addAccount(Account account, long id) {
		User user = userRepo.findById(id).get();
		account.setUser(user);
		accountRepo.save(account);
	}
	
	public void deleteAccount(long id) {
		accountRepo.deleteById(id);
	}
}
