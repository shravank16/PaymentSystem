package com.example.PaymentSystem.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Biller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "biller")
	@JsonIgnore
	private Set<Bill> bills = new HashSet<>();
	
	public Biller() {
		super();
	}
	
	public Biller(long id, String name, Set<Bill> bills) {
		super();
		this.id = id;
		this.name = name;
		this.bills = bills;
	}
	
	public void addBill(Bill bill) {
		bills.add(bill);
	}
	
	public Set<Bill> getBills() {
		return bills;
	}
	
	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Biller [id=" + id + ", name=" + name + "]";
	}
}
