package com.cg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Order;
import com.cg.service.IOrderService;

@RestController
@RequestMapping("/OrderController")
/*
 * @RestController This annotation for developing a RESTful web service with the Spring MVC framework. 
 */
public class OrderController 
{
	/* Logger will help to Know the backgroung Process when the services are started,
	   when the service has stoped logger is default in SpringBoot.
	*/
	Logger log=LoggerFactory.getLogger(OrderController.class);
	/*
	 * Spring @Autowired annotation is used for automatic injection of beans and Setter methods. 
	 */
	@Autowired
	private IOrderService service;

	
	/*
	 *  @PostMapping annotated method handle the HTTP POST requests matched with given URI expression.
	 */
	/*
	 * http://localhost:8081/OrderController/addOrderDetails
	 */
	@PostMapping("/addOrderDetails")
	/*
	 * @RequestBody This annotation can convert in bound HTTP data into Java objects passed into the controller's handler method. 
	 */
	
	public Order addOrderDetails(@RequestBody Order order)
	{
		Order od1=service.addOrder(order);
		log.info("Order Details are added Successful");
		return od1;
	}
}
