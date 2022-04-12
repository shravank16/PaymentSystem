package com.example.PaymentSystem.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String password;
	private String role;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Account> accounts = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user_bill")
	@JsonIgnore
	private Set<Bill> bills = new HashSet<>();
	
	@OneToOne
	private Transaction transactions;
	
	public User() {
		super();
	}
	
	public User(long id, String username, String password, String role, Set<Account> accounts, Set<Bill> bills,
			Transaction transactions) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.accounts = accounts;
		this.bills = bills;
		this.transactions = transactions;
	}
	
	public void addAccount(Account account) {
		accounts.add(account);		
	}
	
	public void addBill(Bill bill) {
		bills.add(bill);
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public Set<Bill> getBills() {
		return bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

	public Transaction getTransactions() {
		return transactions;
	}

	public void setTransactions(Transaction transactions) {
		this.transactions = transactions;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", accounts="
				+ "]";
	}
}
