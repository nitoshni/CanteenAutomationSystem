package com.cg.dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.model.Customer;

/*
 * Indicates that an annotated class is a "Repository".This provide the transaction with db server. 
 */
@Repository
public interface CustomerJPARepository extends JpaRepository<Customer, Integer> {
	/* We can use the JpaRepository interface from Spring framework,which provides a default implementation for the basic
	   CRUD operations.
	 * In order to define SQL to execute for a Spring Data repository method,we can annotate the method with the @Query.
	 * nativeQuery attribute contains the JPQL or SQL to execute.
	 */
	
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

