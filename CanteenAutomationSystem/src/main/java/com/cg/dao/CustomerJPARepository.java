package com.cg.dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.model.Customer;



@Repository
public interface CustomerJPARepository extends JpaRepository<Customer, Integer> {
	
	@Query(value="select * from  Customer where CanteenStaffname=?1",nativeQuery = true)
	public List<Customer> findByCustomerName1(String custName);
	@Query(value="select * from   Customer where Customer_Id=?1",nativeQuery = true)
	public Customer addCustomer(Customer customer);
	@Query(value="select * from   Customer where Customer_Id=?1",nativeQuery = true)
	public List<Customer> viewCustomers();
	@Query(value="select * from   Customer where Customer_Id=?1",nativeQuery = true)
	public Customer updateCustomer(Customer customer);
	@Query(value="select * from   Customer where Customer_Id=?1",nativeQuery = true)
	public Customer deleteCustomer(int customerId);
	@Query(value="select * from   Customer where Customer_Id=?1",nativeQuery = true)
	public Customer viewCustomer(int customerId);
	@Query(value="select * from   Customer where  Customername=?1",nativeQuery = true)
	public List<Customer> findByCustomerName(String userName);

}
