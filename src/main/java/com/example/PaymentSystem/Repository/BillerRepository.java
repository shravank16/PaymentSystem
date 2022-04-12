package com.example.PaymentSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PaymentSystem.entity.Biller;

public interface BillerRepository extends JpaRepository<Biller, Long>{

}
