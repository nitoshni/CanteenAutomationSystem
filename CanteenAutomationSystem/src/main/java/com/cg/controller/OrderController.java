package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.model.Order;
import com.cg.service.IOrderService;

@RestController
//@RestController This annotation for developing a RESTful web service with the Spring MVC framework. 
public class OrderController 
{
//Spring @Autowired annotation is used for automatic injection of beans and Setter methods. 
@Autowired
	private IOrderService service;

// @PostMapping annotated method handle the HTTP POST requests matched with given URI expression.
@PostMapping("/addOrderDetails")
//@RequestBody This annotation can convert in bound HTTP data into Java objects passed into the controller's handler method. 
	public Order addOrderDetails(@RequestBody Order order)
	{
		Order od1=service.addOrder(order);
		System.out.println("Order Details are added Successful");
		return od1;
	}
}
