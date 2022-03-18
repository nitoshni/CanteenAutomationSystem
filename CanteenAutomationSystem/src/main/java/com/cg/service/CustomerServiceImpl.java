package com.cg.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.dao.CustomerJPARepository;
import com.cg.model.Customer;

@Service
	public abstract class CustomerServiceImpl implements ICustomerService {
		@Autowired
		private CustomerJPARepository customerRepo;
		
		public List<Customer> getAllCustomers(){
			return customerRepo.findAll();
		}
		
		public Customer findCustomer(Integer CustomerId) {
			Optional<Customer>cust=customerRepo.findById(CustomerId);
			return cust.get();
		}
		
		public List<Customer> deleteCustomer(Integer CustomerId) {
			customerRepo.deleteById(CustomerId);
			return  customerRepo.findAll();
		}
		
		public List<Customer> saveCustomer(Customer customer) {
			customerRepo.saveAndFlush(customer);
			return  customerRepo.findAll();
		}
		
		public Customer saveCustomer2(Customer customer) {
		System.out.println("inside save2");
			return customerRepo.save(customer);
		}

		public List<Customer> updateCustomer1(Customer customer) {
			customerRepo.saveAndFlush(customer);
			return  customerRepo.findAll();
		}

		public List<Customer> saveAll() {
			return null;
		}

		@Override
		public List<Customer> findByCustomerName(String UserName) {
			List<Customer>cust=customerRepo.findByCustomerName( UserName);//custom methods of repository
			return cust;
		}

	}


