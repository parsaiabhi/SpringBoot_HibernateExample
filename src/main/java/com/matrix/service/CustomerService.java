package com.matrix.service;

import java.util.List;

import com.matrix.model.Customer;

public interface CustomerService {

	public List<Customer> displayAllCustomer();
	public Customer displayCustomerById(int id);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(int id);
	public Customer addCustomer(Customer customer);
}
