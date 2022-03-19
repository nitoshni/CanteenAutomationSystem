package com.cg.service;

import com.cg.model.Order;

/* We are using Service package to implement curd operations....
 * Like add,update,delete,view.
 */
public interface IOrderService
{
	public Order addOrder(Order order);
   
	public  Order updateOrder(Order order);
    
	public  Order deleteOrder(int orderId);
    
	public Order viewOrder(int orderId);
}