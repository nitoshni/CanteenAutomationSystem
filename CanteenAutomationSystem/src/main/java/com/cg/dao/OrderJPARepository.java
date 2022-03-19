package com.cg.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.model.Order;
import com.cg.model.ProductsOrder;

@Repository
//Indicates that an annotated class is a "Repository".This provide the transaction with db server.
public interface OrderJPARepository  extends  JpaRepository<Order, Integer>
{
	/* We can use the JpaRepository interface from Spring framework,which provides a default implementation for the basic
	   CRUD operations.
	*/
	@Query(value="select * from Order where order_date=?1",nativeQuery = true)
	public List<Order> viewOrdersLists(LocalDate date);
	@Query( value="select * from Order where quantity=?1",nativeQuery = true)
	public List<Order> caluculateTotal(String size);
}
