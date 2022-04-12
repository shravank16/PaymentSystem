package com.example.PaymentSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PaymentSystem.entity.Account;
import com.example.PaymentSystem.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping()
	public List<Account> getAllAccounts(){
		return accountService.getAllAccounts();
	}
	
	@PostMapping("/user/{id}")
	public String addAccount(@RequestBody Account account, @PathVariable long id) {
		accountService.addAccount(account, id);
		return "Successful";
	}
	
	@DeleteMapping("/{id}")
	public String deleteAccount(@PathVariable long id) {
		accountService.deleteAccount(id);
		return "Successful";
	}
}
