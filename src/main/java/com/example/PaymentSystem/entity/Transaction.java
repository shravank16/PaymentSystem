package com.example.PaymentSystem.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne()
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User owner;
	@OneToOne()
	private Bill bill;
	private Date date;
	private Double amount;
	private String transactionType;
	private String description;
	
	public Transaction() {
		super();
	}

	public Transaction(long id, User owner, Bill bill, Date date, Double amount, String transactionType,
			String description) {
		super();
		this.id = id;
		this.owner = owner;
		this.bill = bill;
		this.date = date;
		this.amount = amount;
		this.transactionType = transactionType;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", owner=" + owner + ", bill=" + bill + ", date=" + date + ", amount=" + amount
				+ ", transactionType=" + transactionType + ", description=" + description + "]";
	}
}
