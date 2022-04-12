package com.example.PaymentSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PaymentSystem.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
