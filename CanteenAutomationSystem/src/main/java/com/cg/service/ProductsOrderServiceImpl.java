package com.cg.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.ProductsOrderJPARepository;
import com.cg.model.Products;
import com.cg.model.ProductsOrder;

	@Service
	public  class ProductsOrderServiceImpl implements IProductsService {
	@Autowired
	private ProductsOrderJPARepository productsOrderRepo;

	public List<ProductsOrder> getAllProductsOrder(){
	return productsOrderRepo.findAll();
	}

	public ProductsOrder findProductsOrder(Integer ProductsOrderId) {
	Optional<ProductsOrder>cust=productsOrderRepo.findById(ProductsOrderId);
	return cust.get();
	}

	public List<ProductsOrder> deleteProductsOrder(Integer ProductsOrderId) {
	productsOrderRepo.deleteById(ProductsOrderId);
	return productsOrderRepo.findAll();
	}

	public List<ProductsOrder> saveProductsOrder(ProductsOrder productsOrder) {
	productsOrderRepo.saveAndFlush(productsOrder);
	return productsOrderRepo.findAll();
	}

	public ProductsOrder saveProductsOrder2(ProductsOrder productsOrder) {
	System.out.println("inside save2");
	return productsOrderRepo.save(productsOrder);
	}



	public List<ProductsOrder> updateProductsOrder1(ProductsOrder productsOrder) {
	productsOrderRepo.saveAndFlush(productsOrder);
	return productsOrderRepo.findAll();
	}



	public List<Products> saveAll() {
	return null;
	}



	@Override
	public List<ProductsOrder> findByProductsOrderName(String UserName) {
	List<ProductsOrder>cust=productsOrderRepo.findByProductsOrderName( UserName);
	return cust;
	}

	@Override
	public Products bookProductsOrder(ProductsOrder order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Products updateProductsorder(ProductsOrder order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Products cancelProductsorder(int productsId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Products viewProductsorder(int productsId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> viewProductsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> viewProductsLists(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> caluculateTotal(String quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Products updateProducts(Products products) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Products saveProducts(Products products) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Products deleteProducts(Integer productsId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> findProductAbovePrice(Double productsPr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> findByProductName(String productsName) {
		// TODO Auto-generated method stub
		return null;
	}



}

