package com.cg.service;

import java.util.List;

import com.cg.exception.DiscountCouponIdNotFoundException;
import com.cg.exception.InvalidDiscountCouponOperationException;
import com.cg.model.DiscountCoupon;

public interface IDiscountCouponService {
	
		public DiscountCoupon addDiscountCoupon(DiscountCoupon discountCoupon);
		/*
		 * adding Discount coupon details in the database.
		 */

	   
		public DiscountCoupon updateDiscountCoupon(DiscountCoupon discountCoupon)throws InvalidDiscountCouponOperationException;
		/*
		 * updating discount coupon details using Invalid Coupon Exception.
		 */

		public DiscountCoupon deleteDiscountCoupon(int discountCouponId) throws DiscountCouponIdNotFoundException;
		/*
		 * Deleted Discount coupon .
		 */

		public List<DiscountCoupon> viewDiscountCoupon();

		public DiscountCoupon viewDiscountCoupon(int discountCouponId) throws DiscountCouponIdNotFoundException;
		/*
		 *  Viewing the discount coupon details.
		 */
}