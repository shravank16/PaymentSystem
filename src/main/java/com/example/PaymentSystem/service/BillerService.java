package com.example.PaymentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PaymentSystem.Repository.BillerRepository;
import com.example.PaymentSystem.entity.Biller;

@Service
public class BillerService {

	@Autowired
	BillerRepository billerRepo;
	
	public List<Biller> getAllBiller(){
		return billerRepo.findAll();
	}
	
	public Biller addBiller(Biller biller) {
		return billerRepo.save(biller);
	}
	
	public void deleteBiller(long id) {
		billerRepo.deleteById(id);
	}
}
