package com.example.PaymentSystem.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PaymentSystem.Repository.BillRepository;
import com.example.PaymentSystem.Repository.BillerRepository;
import com.example.PaymentSystem.Repository.TransactionRepository;
import com.example.PaymentSystem.Repository.UserRepository;
import com.example.PaymentSystem.entity.Bill;
import com.example.PaymentSystem.entity.Biller;
import com.example.PaymentSystem.entity.Transaction;
import com.example.PaymentSystem.entity.User;
import com.example.PaymentSystem.exceptions.ResourceNotFoundException;

@Service
public class BillService {
	
	private static final Logger log = LoggerFactory.getLogger(BillService.class);

	@Autowired
	BillRepository billRepo;
	
	@Autowired
	BillerRepository billerRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	TransactionRepository transactionRepo;
	
	@Autowired
	EmailService emailService;
	
	public List<Bill> getBillsById(long billId){
		log.info("get bill by id");
		return billRepo.findAllBillById(billId);
	}
	
	public List<Bill> getAllBills(){
		log.info("getting all bills");
		return billRepo.findAll();
	}
	
	public List<Bill> getBillByStatus(String param){
		log.info("getting bill by status");
		return billRepo.getBillByStatus(param);
	}
	
	public Bill createBill(long billerId, long userId, Bill bill) throws ResourceNotFoundException {
		Biller biller = billerRepo.findById(billerId).get();
		User user = userRepo.findById(userId).get();
		if(user == null || biller == null) {
			log.debug("User or biller objects null");
			throw new ResourceNotFoundException("User or biller does not exist.");
		}
		biller.addBill(bill);
		user.addBill(bill);
		bill.setUser(user);
		bill.setBiller(biller);
		return billRepo.save(bill);
	}
	
	public void payBill(long id, double amount) {
		log.info("Paid bill");
		transactionRepo.save(new Transaction(amount, new Date(), "Description"));
		emailService.sendemail("Test email", "Testing email service", "shravankumar5410@gmail.com");
		billRepo.payBill(id, amount);
	}
	
	public void deleteBill(long id) {
		log.info("Deleted bill");
		billRepo.deleteById(id);
	}
}
