package com.cg.service;

import java.util.List;


import com.cg.exception.CustomerIdNotFoundException;
import com.cg.model.Customer;
	//We are using Service package to implement CURD operations....
	 //Like add,update,delete,view.
	
	public interface ICustomerService 
	{
		public Customer addCustomer(Customer customer);
	    //adding details in the database.
		public Customer updateCustomer(Customer customer);
	    //updating details in customer table.
		public Customer deleteCustomer(int customerId) throws CustomerIdNotFoundException;
	    //deleting details in customer table by Id we are using CustomerIdNotFoundException.
		public List<Customer> viewCustomers();
	    //viewing customer details.
		public Customer viewCustomer(int customerId)throws CustomerIdNotFoundException;
		//viewing customer details by Id we are using CustomerIdNotFoundException.
		List<Customer> findByCustomerName(String UserName);
	}
