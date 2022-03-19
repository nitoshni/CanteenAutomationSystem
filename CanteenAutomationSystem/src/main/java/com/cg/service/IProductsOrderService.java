package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.model.ProductsOrder;
/* We are using Service package to implement curd operations....
 * Like add,update,delete,view.
 */
public interface IProductsOrderService 
{
	public ProductsOrder  bookProductsOrder(ProductsOrder order);
	//adding booking details`in the Productsorder  table.
	public ProductsOrder  updateProductsorder (ProductsOrder  order);
	//updating Productsorder  details in the Productsorder  table.
	public ProductsOrder  cancelProductsorder (int orderId);
	//cancelling the Productsorder  and we are using OrderIdNotFoundException.
	public ProductsOrder  viewProductsorder (int orderId);
	//viewing Productsorder  list by Id  we are using OrderIdNotFoundException.
	public List<ProductsOrder > viewOrdersList();
	//viewing Productsorder  list
	public List<ProductsOrder > viewOrdersLists(LocalDate date);
	//viewing Productsorder list by localdate.
	public List<ProductsOrder > caluculateTotal(String size);
	//viewing  Productsorder  list by size we are using InvalidSizeException.
}