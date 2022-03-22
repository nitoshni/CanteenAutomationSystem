package com.cg.service;

import java.util.List;

import com.cg.exception.CustomerIdNotFoundException;
import com.cg.model.Customer;

public interface ICustomerService 
{
	public Customer addCustomer(Customer customer);
	/*
	 * adding Customer details in the database.
	 */
   
	public Customer updateCustomer(Customer customer);
	/*
	 * updating the customer details using CustomerIdException.
	 */
	
  
	public Customer deleteCustomer(int customerId) throws CustomerIdNotFoundException;
	/*
	 * deleting the customer details.
	 */
    
	public Customer viewCustomer(int customerId) throws CustomerIdNotFoundException;

	/*
	 * viewing the customer details.
	 */
	
	public List<Customer> viewCustomers();
}