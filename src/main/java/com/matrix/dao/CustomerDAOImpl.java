package com.matrix.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.matrix.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Customer> getAllCustomer() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customerList = session.createQuery("from Customer").list();
		return customerList;
	}

	@Override
	public Customer getCustomerById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = session.load(Customer.class, new Integer(id));
		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(customer);

	}

	@Override
	public void deleteCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = session.load(Customer.class, new Integer(id));
		if (customer != null) {
			session.delete(customer);
		}

	}

	@Override
	public Customer addCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(customer);

		return customer;
	}

}
