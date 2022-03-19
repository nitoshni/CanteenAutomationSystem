package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.model.Products;
import com.cg.model.ProductsOrder;

public interface IProductsService {

	public Products  bookProductsOrder(ProductsOrder order);
	
	public Products  updateProductsorder (ProductsOrder  order);
	
	public Products  cancelProductsorder (int productsId);
	
	public Products  viewProductsorder (int productsId);

	public List<Products > viewProductsList();
	
	public List<Products > viewProductsLists(LocalDate date);
	
	public List<Products > caluculateTotal(String quantity);

	List<ProductsOrder> findByProductsOrderName(String UserName);

	public Products updateProducts(Products products);

	public Products saveProducts(Products products);

	public Products deleteProducts(Integer productsId);

	public List<Products> findProductAbovePrice(Double productsPr);

	public List<Products> getAllProducts();

	public List<Products> findByProductName(String productsName);
	

}
