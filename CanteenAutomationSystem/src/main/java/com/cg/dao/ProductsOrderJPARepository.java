package com.cg.dao;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.model.ProductsOrder;
//Indicates that an annotated class is a "Repository".This provide the transaction with db server.
@Repository
public interface ProductsOrderJPARepository  extends  JpaRepository<ProductsOrder, Integer>
{
	/* We can use the JpaRepository interface from Spring framework,which provides a default implementation for the basic
	   CRUD operations.
	 * In order to define SQL to execute for a Spring Data repository method,we can annotate the method with the @Query.
	 * nativeQuery attribute contains the JPQL or SQL to execute.
	 */
	@Query(value="select * from productsorder where order_date=?1",nativeQuery = true)
	public List<ProductsOrder> viewOrdersLists(LocalDate date);
	@Query( value="select * from productsorder where size=?1",nativeQuery = true)
	public List<ProductsOrder> caluculateTotal(String size);
	public List<ProductsOrder> findByProductsOrderName(String userName);
}
