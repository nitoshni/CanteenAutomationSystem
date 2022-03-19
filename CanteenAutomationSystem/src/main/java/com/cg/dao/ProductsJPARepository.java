package com.cg.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Products;
import java.util.List;

import org.springframework.data.jpa.repository.Query;


//Indicates that an annotated class is a "Repository".This provide the transaction with db server.
@Repository
public interface ProductsJPARepository extends  JpaRepository<Products, Integer>
{
	/* We can use the JpaRepository interface from Spring framework,which provides a default implementation for the basic
	   CRUD operations.
	 * In order to define SQL to execute for a Spring Data repository method,we can annotate the method with the @Query.
	 * nativeQuery attribute contains the JPQL or SQL to execute.
	 */
	@Query( value="select * from products where product_cost=?1",nativeQuery = true)
	public List<Products> viewProductsList(double minCost);
	@Query(value="select * from products where product_type=?1",nativeQuery=true)
	public List<Products> viewProductsLists(String productType);
	
	@Query(value="select * from products where product_price=?1",nativeQuery=true)
	public List<Products> getByPrice(Double price);
	
	
	@Query(value="select * from products where product_price=?1",nativeQuery=true)
	public List<Products> findByProductName(String prName);

}

