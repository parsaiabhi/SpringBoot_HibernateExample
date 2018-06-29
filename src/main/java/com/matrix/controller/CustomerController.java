package com.matrix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.matrix.model.Customer;
import com.matrix.service.CustomerService;

/**
 * @author abhishek
 *
 */
@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerServiceImpl;
	
	@RequestMapping(value = "/getAllCusotmers" ,method = RequestMethod.GET, headers = "Accept=application/json")
	public String getAllCustomers(Model model){
		 List<Customer> customerList = customerServiceImpl.displayAllCustomer();
		 
		 model.addAttribute("customer", new Customer());
		 model.addAttribute("list", customerList);
		 return "customerdetails";
		 
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage(){
		return "redirect:/getAllCusotmers";
	}
	
	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Customer getCustomerById(@PathVariable("id") int id){
		return customerServiceImpl.displayCustomerById(id);
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addCustomer(@ModelAttribute("customer")Customer customer ){
		if(customer.getId() == 0){
		customerServiceImpl.addCustomer(customer);
		}
		customerServiceImpl.updateCustomer(customer);
		
		return "redirect:/getAllCusotmers";
	}

	@RequestMapping(value = "/updateCusotmer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateCustomer(@PathVariable("id") int id,Model model){
		model.addAttribute("customer", this.customerServiceImpl.displayCustomerById(id));
		model.addAttribute("customerList", this.customerServiceImpl.displayAllCustomer());
		
		
		return "customerdetails";
	}	
	
	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCustomer(@PathVariable("id") int id){
			customerServiceImpl.deleteCustomer(id);
		return "redirect:/getAllCusotmers";
	}
	
	
		
		
	
	
	
	
}
