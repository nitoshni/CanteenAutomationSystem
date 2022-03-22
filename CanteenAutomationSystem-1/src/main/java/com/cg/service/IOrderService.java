package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.exception.OrderIdNotFoundException;
import com.cg.model.Order;

public interface IOrderService
{
	public Order addOrder(Order order);
	/*
	 * adding Order details in the database.
	 */
   
	public  Order updateOrder(Order order);

	/*
	 *  updating order and we are using OrderIdNotFoundException.
	 */
    
	public  Order deleteOrder(int orderId) throws OrderIdNotFoundException;

	/*
	 *  deleting order details.
	 */
    
	public Order viewOrder(int orderId) throws OrderIdNotFoundException;
	/*
	 * viewing order details.
	 */

	List<Order> viewOrdersList();

	List<Order> viewOrdersLists(LocalDate date);
}
