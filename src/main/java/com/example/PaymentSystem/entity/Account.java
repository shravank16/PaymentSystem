package com.example.PaymentSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String accountNumber;
	private String fname;
	private String lname;
	private String email;
	private double balance;
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;
	
	public Account() {
		super();
	}
	
	public Account(long id, String accountNumber, String fname, String lname, String email, double balance, User user) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.balance = balance;
		this.user = user;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", fname=" + fname + ", lname=" + lname
				+ ", email=" + email + ", balance=" + balance + "]";
	}
}
