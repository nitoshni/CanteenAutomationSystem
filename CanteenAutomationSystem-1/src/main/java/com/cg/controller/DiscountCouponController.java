package com.cg.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.DiscountCouponIdNotFoundException;
import com.cg.exception.InvalidDiscountCouponOperationException;
import com.cg.model.DiscountCoupon;
import com.cg.service.IDiscountCouponService;
/*
 * @RestController This annotation for developing a RESTful web service with the Spring MVC framework.
 */
@RestController
@RequestMapping("/DiscountCouponController")
public class DiscountCouponController {
	/* Logger will help to Know the backgroung Process when the services are started,
	   when the service has stoped logger is default in SpringBoot.
	*/
	Logger log=LoggerFactory.getLogger(DiscountCouponController.class);
	/*
	 * Spring @Autowired annotation is used for automatic injection of beans and Setter methods.
	 */
	@Autowired
	private IDiscountCouponService service;
	/*
	 * @PostMapping annotated method handle the HTTP POST requests matched with given URI expression.
	 */
	/*
	 * http://localhost:8081/DiscountCouponController/createDiscountCoupon
	 */
	@PostMapping("/createDiscountCoupon")

	public DiscountCoupon addDiscountCoupon(@RequestBody DiscountCoupon discountCoupon)
	{
		DiscountCoupon cust=(DiscountCoupon) service.addDiscountCoupon(discountCoupon);
		log.info("DiscountCoupon Details Added Successful");
		return cust;
	}
	/*
	 * @GetMapping Annotation for mapping HTTP GET requests onto specific handler methods.
	 */
	/*
	 * @RequestBody This annotation can convert in bound HTTP data into Java objects passed into the controller's handler method.
	 */

	/*
	 * @GetMapping Annotation for mapping HTTP GET requests onto specific handler methods.
	 */
	/*
	 * http://localhost:8081/DiscountCouponController/getDiscountCoupon
	 */
	@GetMapping("/getDiscountCoupon")
	public List<DiscountCoupon> viewDiscountCoupon()
	{
		log.info("DiscountCoupon Details viewed Successful");
	return service.viewDiscountCoupon();
	}
	/*
	 * @PutMaping Annotation for mapping HTTP PUT requests onto specific handler methods.
	 */
	/*
	 * @Path variable This is another annotation that is used to retrieve data from the URL
	 */
	/*
	 * http://localhost:8081/DiscountCouponController/updateDiscountCoupon/{DiscountCouponId}
	 */
	@PutMapping("/updateDiscountCoupon/{DiscountCouponId}")
	public DiscountCoupon updateDiscountCoupon(@RequestBody DiscountCoupon discountCoupon,@PathVariable int discountCouponId) throws InvalidDiscountCouponOperationException
	{
		log.info("DiscountCoupon Details Updated Successful by Id");
	return service.updateDiscountCoupon(discountCoupon);
	}
	/*
	 * @DeleteMaping Annotation for mapping HTTP DELETE requests onto specific handler methods.
	 */
	/*
	 * http://localhost:8081/DiscountCouponController/deleteDiscountCoupon/{DiscountCouponId}
	 */
	@DeleteMapping("/deleteDiscountCoupon/{DiscountCouponId}")
	public DiscountCoupon deleteDiscountCoupon(@PathVariable int discountCouponId) throws DiscountCouponIdNotFoundException
	{
		log.info("DiscountCoupon Details delete Successful by Id");
	return service.deleteDiscountCoupon(discountCouponId);
	}
	/*
	 * http://localhost:8081/DiscountCouponController/getDiscountCouponById/{DiscountCouponId}
	 */
	@GetMapping("/getDiscountCouponById/{DiscountCouponId}")
	public DiscountCoupon viewDiscountCoupon(@PathVariable int DiscountCouponId) throws DiscountCouponIdNotFoundException
	{
		log.info("DiscountCoupon Details viewed Successful by Id");
	return service.viewDiscountCoupon(DiscountCouponId);
	}
}