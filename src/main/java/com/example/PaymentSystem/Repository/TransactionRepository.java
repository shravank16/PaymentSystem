package com.example.PaymentSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PaymentSystem.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
}
