package com.cg.controller;

import java.util.List;
import com.cg.model.Products;
import com.cg.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProductsController {
	@Autowired
	private IProductsService productService;
	
	//http://localhost:8080/ProductApp/api/v1/products
	@PutMapping("/products")
	public Products updateProduct(
			@RequestBody Products products){
		System.out.println(products);
		Products products1= productService.updateProducts(products);
		return products;
	}
	
	
	
	@PostMapping("/products")
	public Products saveproducts (@RequestBody Products products){
		Products products1= productService.saveProducts(products);
		System.out.println(products);
		return products;
	}
	
	
	
	
	@DeleteMapping("/products/{productId}")
	public  Integer deleteProduct(
			@PathVariable("productsId")Integer productsId){
		Products products= productService.deleteProducts(productsId);
		System.out.println(productsId);
		return productsId;
		
	}
	
	
	@GetMapping("/products/{productId}")
	public Double findProduct(
			@PathVariable("productId")Double productsPr){
		List<Products> productsPr1= productService.findProductAbovePrice(productsPr);
		System.out.println("products are");
		return productsPr;
	
	}

	
	//http://localhost:8080/ProductApp/api/v1/products/getproduct
	@GetMapping("/products/getproduct")
	public List<Products> getAllProducts(@PathVariable("productsId")Integer productsId){
		List<Products> products= productService.getAllProducts();
		System.out.println("products");
		return products;
	}
	
	////http://localhost:8080/ProductApp/api/v1/products
	@GetMapping("/productsname/{productName}")
	public  String getAllProductsByName(@PathVariable("productName")String productsName){
		System.out.println("Product names are");
	
		List<Products> products= productService.findByProductName(productsName);
		return productsName;
		
	}
	
	
}

