package com.cg.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.CustomerJPARepository;
import com.cg.exception.CustomerIdNotFoundException;
import com.cg.model.Customer;

/* Indicates that an annotated class is a “Service”.
This annotation serves as a specialization of @Component,
allowing for implementation classes to be autodetected through classpath scanning.
*/
@Service
public class CustomerServiceImpl implements ICustomerService {
	/*
	 * Spring @Autowired annotation is used for automatic injection of beans and Setter methods.
	 */
	@Autowired
	private CustomerJPARepository repository;
	/*
	 * @Override annotation methods which are not implemented this methods are used in Interface..
	 */
	@Override
	/*
	 * adding the customer details
	 */
	public Customer addCustomer(Customer customer) 
	{
		Customer cust=repository.save(customer);
		return cust;
	}

	@Override
	/*
	 * updating customer details
	 */
	public Customer updateCustomer(Customer customer) {
		Customer customer1=repository.getById(customer.getCustomerId());
		return repository.save(customer1);
	}

	@Override
	/*
	 * deleting the customer details
	 */
	public Customer deleteCustomer(int customerId) throws CustomerIdNotFoundException {
		if(repository.existsById(customerId))
		{
			Customer cust1=repository.getById(customerId);
			repository.delete(cust1);
			return cust1;
		}
		else
		{
			throw new CustomerIdNotFoundException("customer is not found in the database");
		}
	}
	@Override
	/*
	 * viewing the customer details
	 */
	public List<Customer> viewCustomers() 
	{
		List<Customer> listCustomer=repository.findAll();
		return listCustomer;
	}

	@Override
	public Customer viewCustomer(int customerId) throws CustomerIdNotFoundException 
	{
		Optional<Customer> found=repository.findById(customerId);
		if(found.isPresent())
		{
			return found.get();
		}
		else
		{
			throw new CustomerIdNotFoundException("customerId is not exits");
		}
	}



}

