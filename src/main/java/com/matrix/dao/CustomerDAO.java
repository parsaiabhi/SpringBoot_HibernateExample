package com.matrix.dao;

import java.util.List;

import com.matrix.model.Customer;

public interface CustomerDAO {

	public List<Customer> getAllCustomer();
	public Customer getCustomerById(int id);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(int id);
	public Customer addCustomer(Customer customer);
	
}
