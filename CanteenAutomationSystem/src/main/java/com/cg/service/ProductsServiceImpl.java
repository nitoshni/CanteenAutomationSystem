package com.cg.service;



import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.ProductsJPARepository;
import com.cg.model.Products;
import com.cg.model.ProductsOrder;


@Service
public class ProductsServiceImpl implements IProductsService
{
	@Autowired
	private ProductsJPARepository productRepo;

	public List<Products> getAllProducts() {
		return productRepo.findAll();
	}
	public Products findProduct(Integer productId) {
		Optional<Products>prod=productRepo.findById(productId); //predefined method
		return prod.get();
	}
	public List<Products> deleteProduct(Integer productId) {
		productRepo.deleteById(productId);
		return  productRepo.findAll();
	}
	public List<Products> saveProduct(Products product) {
		productRepo.saveAndFlush(product);
		return  productRepo.findAll();
	}
	
	
	public Products saveProduct2(Products product) {
	System.out.println("inside save2");
		return productRepo.save(product);
	}

	public List<Products> updateProduct(Products product) {
		productRepo.saveAndFlush(product);
		return  productRepo.findAll();
	}

	public List<Products> saveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Products> findByProductName(String prName) {
		List<Products> prd=productRepo.findByProductName(prName);//custom methods of repository
		return prd;
	}
	
	public List<Products> findProductAbovePrice(Double price) {
		List<Products> prd=productRepo.getByPrice(price);
		return prd;
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
	public List<ProductsOrder> findByProductsOrderName(String UserName) {
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
}