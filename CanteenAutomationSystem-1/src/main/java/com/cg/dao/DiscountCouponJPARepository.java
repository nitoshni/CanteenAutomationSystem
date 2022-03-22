package com.cg.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.model.DiscountCoupon;
/*
 * Indicates that an annotated class is a "Repository".This provide the transaction with db server. 
 */
@Repository
public interface DiscountCouponJPARepository extends  JpaRepository<DiscountCoupon, Integer>
{	
	/* We can use the JpaRepository interface from Spring framework,which provides a default implementation for the basic
	   CRUD operations.
	 * In order to define SQL to execute for a Spring Data repository method,we can annotate the method with the @Query.
	 * nativeQuery attribute contains the JPQL or SQL to execute.
	 */
	@Query(value="select * from DiscountCoupon where DiscountCoupon_id=?1",nativeQuery = true)
	public List<DiscountCoupon> addDiscountCoupon(DiscountCoupon discountCoupon);
	
	@Query(value="select * from DiscountCoupon where DiscountCoupon_id=?1",nativeQuery = true)
	public List<DiscountCoupon> viewDiscountCoupon();
	
	@Query(value="select * from DiscountCoupon where DiscountCoupon_id=?1",nativeQuery = true)
	public List<DiscountCoupon> updateDiscountCoupon(DiscountCoupon discountCoupon);
	
	@Query(value="select * from DiscountCoupon where DiscountCoupon_id=?1",nativeQuery = true)
	public List<DiscountCoupon> deleteDiscountCoupon(int discountCouponId);
	
	@Query(value="select * from DiscountCoupon where DiscountCoupon_id=?1",nativeQuery = true)
	public List<DiscountCoupon> viewDiscountCoupon(int discountCouponId);
}
