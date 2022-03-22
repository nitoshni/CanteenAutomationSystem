package com.cg.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.OrderJPARepository;
import com.cg.exception.OrderIdNotFoundException;
import com.cg.model.Order;

/* Indicates that an annotated class is a “Service”.
This annotation serves as a specialization of @Component,
allowing for implementation classes to be autodetected through classpath scanning.
*/
@Service
public class OrderServiceImpl implements IOrderService
{
	/*
	 * Spring @Autowired annotation is used for automatic injection of beans and Setter methods.
	 */
	@Autowired
	private OrderJPARepository repository;
	/*
	 * @Override annotation methods which are not implemented this methods are used in Interface..
	 */
	@Override
	/*
	 * adding order details
	 */
	public Order addOrder(Order order) 
	{
		Order po=repository.save(order);
		return po;
	}

	@Override
	/*
	 * updating order details
	 */
	public Order updateOrder(Order order) 
	{
		Order po1=repository.getById(order.getOrderId());
		return repository.save(po1);
	}

	@Override
	/*
	 * deleting order details
	 */
	public Order deleteOrder(int orderId)throws OrderIdNotFoundException
	{
		if(repository.existsById(orderId))
		{
			Order po2=repository.getById(orderId);
			repository.delete(po2);
			return po2;
		}
		else
		{
			throw new OrderIdNotFoundException("OrderId is not found");
		}
	}
	@Override
	/*
	 * viewing order details
	 */
	public Order viewOrder(int orderId)throws OrderIdNotFoundException
	{
		Optional<Order> found=repository.findById(orderId);
		if(found.isPresent())
		{
			return found.get();
		}
		else
		{
			throw new OrderIdNotFoundException("OrderId is not exits");
		}
	}
	@Override
	public List<Order> viewOrdersList() 
	{ 
		List<Order> listOfOrders=repository.findAll();
		return listOfOrders;
	}

	@Override
	public List<Order> viewOrdersLists(LocalDate date) 
	{
		return repository.viewOrdersLists(date);
	}

}