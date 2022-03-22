package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.DiscountCouponJPARepository;
import com.cg.exception.DiscountCouponIdNotFoundException;
import com.cg.exception.InvalidDiscountCouponOperationException;
import com.cg.model.DiscountCoupon;

/* Indicates that an annotated class is a “Service”.
This annotation serves as a specialization of @Component,
allowing for implementation classes to be autodetected through classpath scanning.
*/
@Service
public class DiscountCouponServiceImpl implements IDiscountCouponService{
	/*
	 * Spring @Autowired annotation is used for automatic injection of beans and Setter methods.
	 */
		@Autowired 
		DiscountCouponJPARepository repository;
		/*
		 * @Override annotation methods which are not implemented this methods are used in Interface..
		 */
		@Override
		/*
		 * adding the coupon details
		 */
		
		public DiscountCoupon addDiscountCoupon(DiscountCoupon discountCoupon) {

			DiscountCoupon coup1=repository.save(discountCoupon);
			return coup1;
		}

		@Override
		/*
		 * updating the coupon details
		 */
		public DiscountCoupon updateDiscountCoupon(DiscountCoupon discountCoupon) throws InvalidDiscountCouponOperationException 
		{
		
			if(repository.existsById(discountCoupon.getCouponId()))
			{
				return repository.save(discountCoupon);
		     }
			else
			{
				throw new InvalidDiscountCouponOperationException("invalid discountCoupanId operation");
			}
		}

		@Override
		/*
		 * deleting coupon details
		 */
		public DiscountCoupon deleteDiscountCoupon(int discountCouponId) throws DiscountCouponIdNotFoundException 
		{
			if(repository.existsById(discountCouponId))
			{
			DiscountCoupon coup=repository.getById(discountCouponId);
			repository.delete(coup);
			return coup;
		    }
			else
			{
				throw new DiscountCouponIdNotFoundException("discountCoupan is not found in the database");
			}
		}
		/*
		 * viewing the coupon details
		 */
		@Override
		public List<DiscountCoupon> viewDiscountCoupon() {
			List<DiscountCoupon> listOfCoup=repository.findAll();
			return listOfCoup;
		}
		
		@Override
		public DiscountCoupon viewDiscountCoupon(int discountCouponId) throws DiscountCouponIdNotFoundException 
		{
			Optional<DiscountCoupon> found=repository.findById(discountCouponId);
			if(found.isPresent())
			{
				return found.get();
			}
			else
			{
				throw new DiscountCouponIdNotFoundException("canteenStaffId is not exits");
			}
		}
	}
