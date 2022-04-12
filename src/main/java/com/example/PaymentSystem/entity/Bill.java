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
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private double amount;
	private Date dueDate;
	private String status;
		
	@ManyToOne()
	@JoinColumn(name = "biller_Id")
	private Biller biller;	
	
	@ManyToOne()
	@JoinColumn(name = "bill_user_id")
	private User user_bill;
	
	@OneToOne()
	private Transaction transaction;
	
	public Bill() {
		super();
	}

	public Bill(long id, double amount, Date dueDate, String status, Biller biller, User user_bill,
			Transaction transaction) {
		super();
		this.id = id;
		this.amount = amount;
		this.dueDate = dueDate;
		this.status = status;
		this.biller = biller;
		this.user_bill = user_bill;
		this.transaction = transaction;
	}

	public User getUser() {
		return user_bill;
	}

	public void setUser(User user_bill) {
		this.user_bill = user_bill;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Biller getBiller() {
		return biller;
	}

	public void setBiller(Biller biller) {
		this.biller = biller;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", amount=" + amount + ", dueDate=" + dueDate + ", status=" + status + ", biller="
				+ biller + "]";
	}
}
