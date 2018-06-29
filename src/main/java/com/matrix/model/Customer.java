package com.matrix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VISA_CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "customerName")
	private String customer_Name;
	
	@Column(name = "email")
	private String email;
	
	public Customer() {
		super();
	}

	public Customer(int id, String customer_Name, String email) {
		super();
		this.id = id;
		this.customer_Name = customer_Name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomer_Name() {
		return customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cutomer [id=" + id + ", customer_Name=" + customer_Name + ", email=" + email + "]";
	}
	
	
	
	
	
	
	
	
	
}
