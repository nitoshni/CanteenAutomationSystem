package com.cg.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.ProductsNotFoundException;
import com.cg.model.ProductsOrder;
import com.cg.service.IProductsOrderService;



@RestController
//@RestController This annotation for developing a RESTful web service with the Spring MVC framework. 
public class ProductsOrderController
{
	//Spring @Autowired annotation is used for automatic injection of beans and Setter methods. 
	@Autowired
	private IProductsOrderService service;
	
	// @PostMapping annotated method handle the HTTP POST requests matched with given URI expression.
	@PostMapping("/bookProductsOrder")
	//@RequestBody This annotation can convert inbound HTTP data into Java objects passed into the controller's handler method. 
	public ProductsOrder bookProductsOrder(@RequestBody ProductsOrder  order)
	{
		ProductsOrder productsorder=service.bookProductsOrder(order);
		System.out.println("Products Ordered booked Successful");
		return order;
	}
	// @PutMaping Annotation for mapping HTTP PUT requests onto specific handler methods.
	//@Path variable This is another annotation that is used to retrieve data from the URL
	 @PutMapping("/updateProductsOrder/{orderId}")
	 public ProductsOrder  updateProductsOrder(@RequestBody ProductsOrder  order,@PathVariable int orderId)
	 {
		 ProductsOrder productsorder=service.updateProductsorder(order);
		 System.out.println("Products Ordered updated Successful");
		 return service.updateProductsorder (order);
	 }
	//@DeleteMaping Annotation for mapping HTTP DELETE requests onto specific handler methods.
	 @DeleteMapping("/cancelProductsOrder/{orderId}")
	 public ProductsOrder  cancelProductsorder(@PathVariable int orderId) throws ProductsNotFoundException {
		 System.out.println("Products Ordered Cancelled Successful");
		 return service.cancelProductsorder (orderId);
	 }
	//@GetMapping Annotation for mapping HTTP GET requests onto specific handler methods.
	 @GetMapping("/viewProductsOrder/{orderId}")
	 public ProductsOrder  viewProductsorder (@PathVariable int orderId) throws ProductsNotFoundException
	 {
		 System.out.println("Products Ordered viewed Successful by Id");
		 return service.viewProductsorder(orderId);
	 }
	 @GetMapping("/viewOrderList")
	 public List<ProductsOrder> viewOrderList()
	 {
		 System.out.println("Products Ordered viewed Successful");
		 return service.viewOrdersList();
	 }
	 @GetMapping("/viewOrdersLists/{orderDate}")
	 public List<ProductsOrder> viewOrdersLists(@PathVariable String orderDate)
	 {
		 LocalDate d1=LocalDate.parse(orderDate);
		 System.out.println("Products Ordered viewed Successful by OrderDate");
		 return service.viewOrdersLists(d1);
	 }
	 @GetMapping("/caluculateTotal/{quantity}")
	 public List<ProductsOrder > caluculateTotal(@PathVariable String quantity) throws ProductsNotFoundException 
	 {
		 System.out.println("Products Ordered caluculate Successful by quantity");
		 return service.caluculateTotal(quantity);
	 }
}