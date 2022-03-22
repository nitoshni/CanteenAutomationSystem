package com.cg.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.ProductsOrderJPARepository;
import com.cg.exception.OrderIdNotFoundException;
import com.cg.model.ProductsOrder;

/* Indicates that an annotated class is a “Service”.
This annotation serves as a specialization of @Component,
allowing for implementation classes to be autodetected through classpath scanning.
*/
@Service
public class ProductsOrderServiceImpl implements IProductsOrderService
{
	/*
	 * Spring @Autowired annotation is used for automatic injection of beans and Setter methods.
	 */
	@Autowired
	private ProductsOrderJPARepository repository;
	/*
	 * @Override annotation methods which are not implemented this methods are used in Interface..
	 */
	@Override
	/*
	 * booking the products
	 */
	public ProductsOrder bookProductsOrder(ProductsOrder order) 
	{
		ProductsOrder po=repository.save(order);
		return po;
	}

	@Override
	/*
	 * updating products in the order
	 */
	public ProductsOrder updateProductsOrder(ProductsOrder order) 
	{
		ProductsOrder po1=repository.getById(order.getBookingOrderId());
		 repository.save(po1);
		 return po1;
	}

	@Override
	/*
	 * cancelling the order
	 */
	public ProductsOrder cancelProductsOrder(int orderId)throws OrderIdNotFoundException
	{
		if(repository.existsById(orderId))
		{
			ProductsOrder po2=repository.getById(orderId);
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
	 * viewing the order
	 */
	public ProductsOrder viewProductsOrder(int orderId)throws OrderIdNotFoundException
	{
		Optional<ProductsOrder> found=repository.findById(orderId);
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
	public List<ProductsOrder> viewOrdersList() 
	{ 
		List<ProductsOrder> listOfOrders=repository.findAll();
		return listOfOrders;
	}

	@Override
	public List<ProductsOrder> viewOrdersLists(LocalDate date) 
	{
		return repository.viewOrdersLists(date);
	}

}