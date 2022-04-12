package com.example.PaymentSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PaymentSystem.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
