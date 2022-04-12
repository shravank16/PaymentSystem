package com.example.PaymentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PaymentSystem.Repository.BillRepository;
import com.example.PaymentSystem.Repository.BillerRepository;
import com.example.PaymentSystem.Repository.UserRepository;
import com.example.PaymentSystem.entity.Bill;
import com.example.PaymentSystem.entity.Biller;
import com.example.PaymentSystem.entity.User;

@Service
public class BillService {

	@Autowired
	BillRepository billRepo;
	
	@Autowired
	BillerRepository billerRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public List<Bill> getBillsById(long billId){
		return billRepo.findAllBillById(billId);
	}
	
	public List<Bill> getAllBills(){
		return billRepo.findAll();
	}
	
	public List<Bill> getBillByStatus(String param){
		return billRepo.getBillByStatus(param);
	}
	
	public Bill createBill(long billerId, long userId, Bill bill) {
		Biller biller = billerRepo.findById(billerId).get();
		User user = userRepo.findById(userId).get();
		biller.addBill(bill);
		user.addBill(bill);
		bill.setUser(user);
		bill.setBiller(biller);
		return billRepo.save(bill);
	}
	
	public void payBill(long id, double amount) {
		billRepo.payBill(id, amount);
	}
	
	public void deleteBill(long id) {
		billRepo.deleteById(id);
	}
}
