package com.cg.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.ProductsJPARepository;
import com.cg.exception.ProductsIdNotFoundException;
import com.cg.model.Products;

/* Indicates that an annotated class is a “Service”.
This annotation serves as a specialization of @Component,
allowing for implementation classes to be autodetected through classpath scanning.
*/
@Service
public class ProductsServiceImpl implements IProductsService
{
	/*
	 * Spring @Autowired annotation is used for automatic injection of beans and Setter methods.
	 */
		@Autowired
		public ProductsJPARepository repository;
		/*
		 * @Override annotation methods which are not implemented this methods are used in Interface..
		 */
		@Override
		/*
		 * adding the products
		 */
		public Products addProducts(Products products) 
		{
			Products p=repository.save(products);
			return p;
		}

		@Override
		/*
		 * updating the products
		 */
		public Products updateProducts(Products products) 
		{
			Products p=repository.getById(products.getProductsId());
			return repository.save(p);
		}
		@Override
		/*
		 * deleting the products
		 */
		public Products deleteProducts(int productsId) throws ProductsIdNotFoundException 
		{
			if(repository.existsById(productsId))
			{
				Products products=repository.getById(productsId);
				repository.delete(products);
				return products;
			}
			else
			{
				throw new  ProductsIdNotFoundException("Products Id is not exits");
			}
		}

		@Override
		/*
		 * viewing the product 
		 */
		public Products viewProducts(int productsId) throws ProductsIdNotFoundException 
		{
			Optional<Products> pa=repository.findById(productsId);
			if(pa.isPresent())
			{
				return pa.get();
			}
			else
			{
				throw new  ProductsIdNotFoundException("Products Id is not there");
			}
		}

		@Override
		public List<Products> viewProductsList() 
		{
			List<Products> listProducts=repository.findAll();
			return listProducts;
		}

		@Override
		public List<Products> viewProductsLists(String productsType) {
			return repository.viewProductsLists(productsType);
		}
}
