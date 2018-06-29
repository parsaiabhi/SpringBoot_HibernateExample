package com.matrix.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrix.dao.CustomerDAO;
import com.matrix.model.Customer;

@Service("customerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDao;

	@Override
	@Transactional
	public List<Customer> displayAllCustomer() {

		return customerDao.getAllCustomer();
	}

	@Override
	@Transactional
	public Customer displayCustomerById(int id) {

		return customerDao.getCustomerById(id);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {

		customerDao.updateCustomer(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {

		customerDao.deleteCustomer(id);
	}

	@Override
	@Transactional
	public Customer addCustomer(Customer customer) {

		return customerDao.addCustomer(customer);
	}

}
