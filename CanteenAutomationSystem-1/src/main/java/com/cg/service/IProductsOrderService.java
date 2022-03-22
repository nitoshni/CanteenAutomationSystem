package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.exception.OrderIdNotFoundException;
import com.cg.model.ProductsOrder;

public interface IProductsOrderService 
{
	public ProductsOrder  bookProductsOrder(ProductsOrder order);
	/*
	 * adding bookproductsorder details in the database.
	 */
	
	public List<ProductsOrder > viewOrdersList();

	public List<ProductsOrder > viewOrdersLists(LocalDate date);
	
	ProductsOrder viewProductsOrder(int orderId) throws OrderIdNotFoundException;
	/*
	 * viewing the productsorder details.
	 */
	
	ProductsOrder cancelProductsOrder(int orderId) throws OrderIdNotFoundException;
	/*
	 * Canceeling the order and we are using OrderIDNotFoundException
	 */

	public ProductsOrder updateProductsOrder(ProductsOrder order);
	/*
	 * updating productsorder details.
	 */

}