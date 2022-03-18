package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.model.Customer;

@Repository
public interface CustomerJPARepository extends JpaRepository<Customer, Integer> {
	
	
	public List<Customer> findByProductName(String custName);

	public Customer addCustomer(Customer customer);

	public List<Customer> viewCustomers();

	public Customer updateCustomer(Customer customer);

	public Customer deleteCustomer(int customerId);

	public Customer viewCustomer(int customerId);

	public List<Customer> findByCustomerName(String userName);
	

	
}