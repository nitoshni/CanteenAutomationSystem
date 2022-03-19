package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.dao.OrderJPARepository;
import com.cg.dao.UserJPARepository;
import com.cg.model.Order;
import com.cg.model.User;

public class OrderServiceImpl {
	@Autowired
	private OrderJPARepository orderRepo;

	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}
	public Order findOrder(Integer orderId) {
		Optional<Order>order=orderRepo.findById(orderId); //predefined method
		return order.get();
	}
	public List<Order> deleteUser(Integer orderId) {
		orderRepo.deleteById(orderId);
		return orderRepo.findAll();
	}
	public List<Order> saveProduct(Order order) {
		orderRepo.saveAndFlush(order);
		return  orderRepo.findAll();
	}
	
	
	public Order saveUser2(Order order) {
	System.out.println("inside save2");
		return orderRepo.save(order);
	}

	public List<Order> updateorder(Order order) {
		orderRepo.saveAndFlush(order);
		return orderRepo.findAll();
	}

	public List<Order> saveAll() {
		// TODO Auto-generated method stub
		return null;
	}	
}