package com.example.PaymentSystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.PaymentSystem.entity.Bill;
import com.example.PaymentSystem.entity.Biller;
import com.example.PaymentSystem.entity.User;
import com.example.PaymentSystem.exceptions.ResourceNotFoundException;
import com.example.PaymentSystem.service.BillService;
import com.example.PaymentSystem.service.BillerService;
import com.example.PaymentSystem.service.CsvService;
import com.example.PaymentSystem.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	BillerService billerService;
	
	@Autowired
	BillService billService;
	
	@Autowired
	CsvService fileService;
	
	@CrossOrigin
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/biller")
	public List<Biller> getAllBiller(){
		return billerService.getAllBiller();
	}
	
	@GetMapping("/bill")
	public List<Bill> getAllBills(){
		return billService.getAllBills();
	}
	
	@GetMapping("/bill/{id}")
	public List<Bill> getBillById(@PathVariable long billerId, @PathVariable long billId){
		return billService.getBillsById(billId);
	}
	
	@GetMapping("/bill/get")
	public List<Bill> billByStatus(@RequestParam String status){
		return billService.getBillByStatus(status);
	}
	
	@PostMapping("/biller")
	public String createBiller(@RequestBody Biller biller) {
		billerService.addBiller(biller);
		return "Successful";
	}
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@PostMapping("/biller/{billerId}/user/{userId}/bill") 
	public Bill createBill(@PathVariable long billerId, @PathVariable long userId, @RequestBody Bill bill) throws ResourceNotFoundException {
		return billService.createBill(billerId, userId, bill);
	}
	
	@PutMapping("/bill/{id}/{amount}")
	public String payBill(@PathVariable long id, @PathVariable Double amount) {
		billService.payBill(id, amount);
		return "Successful";
	}
	
	@DeleteMapping("/biller/{id}")
	public String deleteBiller(@PathVariable long id) {
		billerService.deleteBiller(id);
		return "Successful";
	}
	
	@DeleteMapping("/bill/{billId}")
	public void deleteBill(@PathVariable long billId) {
		billService.deleteBill(billId);
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
		return "Successful";
	}
}
