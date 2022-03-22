package com.cg.service;

import java.util.List;

import com.cg.exception.ProductsIdNotFoundException;
import com.cg.model.Products;

public interface IProductsService {

	public Products addProducts(Products products);
	/*
	 * adding Products details in the database.
	 */

	public Products updateProducts(Products products);
	/*
	 * updating products in the database
	 */

	public Products deleteProducts(int productsId) throws ProductsIdNotFoundException;
	/*
	 * deleting products  and we are using ProductsIdNotFoundException
	 */

	public Products viewProducts(int productsId) throws ProductsIdNotFoundException;
	/*
	 * viewing all the products.
	 */

	public List<Products> viewProductsList();

	public List<Products> viewProductsLists(String productsType);
}