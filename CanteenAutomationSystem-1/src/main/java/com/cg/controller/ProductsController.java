package com.cg.controller;

import java.util.List;

import com.cg.exception.ProductsIdNotFoundException;
import com.cg.model.Products;

import com.cg.service.IProductsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 * @RestController This annotation for developing a RESTful web service with the Spring MVC framework.
 */
@RestController
@RequestMapping("/ProductsController")
public class ProductsController {
	/* Logger will help to Know the backgroung Process when the services are started,
	   when the service has stoped logger is default in SpringBoot.
	*/
	Logger log=LoggerFactory.getLogger(ProductsController.class);
	/*
	 * Spring @Autowired annotation is used for automatic injection of beans and Setter methods.
	 */
	@Autowired
	private IProductsService productsService;
	/*
	 * @PutMaping Annotation for mapping HTTP PUT requests onto specific handler methods.
	 */
	/*
	 * @RequestBody This annotation can convert in bound HTTP data into Java objects passed into the controller's han
	 */
	/*
	 * http://localhost:8081/ProductsController/products
	 */
	@PutMapping("/products")
	public Products updateProducts(@RequestBody Products products){
		Products products1= productsService.updateProducts(products);
		log.info("products updated successfully");
		return products1;
	}
	/*
	 * @PostMapping annotated method handle the HTTP POST requests matched with given URI expression.
	 */
	/*
	 * http://localhost:8081/ProductsController/products1
	 */
	@PostMapping("/products1")
	public Products addProducts (@RequestBody Products products){
		Products products1= productsService.addProducts(products);
		log.info("products Added successfully");
		return products1;
	}


	/*
	 * @DeleteMaping Annotation for mapping HTTP DELETE requests onto specific handler methods.
	 */
	/*
	 * http://localhost:8081/ProductsController/products2/{productID}
	 */
	@DeleteMapping("/products2/{productId}")
	public  Integer deleteProduct(
			@PathVariable("productsId")Integer productsId) throws ProductsIdNotFoundException{
		 productsService.deleteProducts(productsId);
		log.info("products updated successfully by Id");
		return productsId;
		
	}
	/*
	 * @GetMapping Annotation for mapping HTTP GET requests onto specific handler methods.
	 */
	/*
	 * @Path variable This is another annotation that is used to retrieve data from the URL
	 */
	/*
	 * http://localhost:8081/ProductsController/getproductsById/{productsId}
	 */
	@GetMapping("/getProductsById/{productsId}")
	public Products viewProducts(@PathVariable("productsId") Integer productsId)throws ProductsIdNotFoundException
	{
		Products products= productsService.viewProducts(productsId);
		log.info("view products by ID");
		return products;
	}
	/*
	 * http://localhost:8081/ProductsController/products/getproducts
	 */
	@GetMapping("/products/getproducts")
	public List<Products> viewProductsList(Integer productsId){
		log.info("products viewed successfully by Id");
		return productsService.viewProductsList();
	}
	/*
	 * http://localhost:8081/ProductsController/productsname/{productsname}
	 */
	@GetMapping("/productsname/{productsName}")
	public  String viewProductsLists(@PathVariable("productsName")String productsName){
		
		 productsService.viewProductsLists(productsName);
		log.info("products viewed successfully by Name");
		return productsName;
		
	}	
}