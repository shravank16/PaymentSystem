package com.example.PaymentSystem.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PaymentSystem.Repository.BillRepository;
import com.example.PaymentSystem.entity.Bill;
import com.example.PaymentSystem.helper.CsvHelper;

@Service
public class CsvService {

	@Autowired
	BillRepository billRepo;
	
	public ByteArrayInputStream load() {
	    List<Bill> tutorials = billRepo.findAll();
	    ByteArrayInputStream in = CsvHelper.tutorialsToCSV(tutorials);
	    return in;
	 }
}
