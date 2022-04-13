package com.example.PaymentSystem;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.PaymentSystem.entity.Account;
import com.example.PaymentSystem.entity.User;
import com.example.PaymentSystem.service.UserService;

@SpringBootTest
class PaymentSystemApplicationTests {

	@Autowired
	UserService userService;
	
	@Test
	public void createUser() {
		User user = new User(1, "Shravan", "password", "Manager", null, null, null);
		User savedUser = userService.createUser(user);
		assertNotNull(savedUser);
	}
	
	@Test
	public void createAccount() {
		Account account = new Account(1, "1234", "", "", "", 0.0, null);
		assertNotNull(account);
	}
	
	@Test
	public void createBill() {
		Account account = new Account(1, "1234", "", "", "", 0.0, null);
		assertNotNull(account);
	}
	
	@Test
	public void createBiller() {
		Account account = new Account(1, "1234", "", "", "", 0.0, null);
		assertNotNull(account);
	}

}
