package com.cg.controller;

import java.time.LocalDate;
import java.util.List;

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

import com.cg.exception.OrderIdNotFoundException;

import com.cg.model.ProductsOrder;
import com.cg.service.IProductsOrderService;



/*
 * @RestController This annotation for developing a RESTful web service with the Spring MVC framework.
 */
@RestController
@RequestMapping("/ProductsOrderController")
public class ProductsOrderController
{/*
	 * Spring @Autowired annotation is used for automatic injection of beans and Setter methods. 
	 */
	@Autowired
	private IProductsOrderService service;

		
		/* Logger will help to Know the backgroung Process when the services are started,
		   when the service has stoped logger is default in SpringBoot.
		*/
		Logger log=LoggerFactory.getLogger(ProductsOrderController.class);
		/*
		 * @PostMapping annotated method handle the HTTP POST requests matched with given URI expression.
		 */
		/*
		 * http://localhost:8081/ProductsOrderController/bookProductsOrder
		 */
		@PostMapping("/bookProductsOrder")
		/*
		 * @RequestBody This annotation can convert inbound HTTP data into Java objects passed into the controller's handler method. 
		 */
		public ProductsOrder bookProductsOrder(@RequestBody ProductsOrder order)
		{
			ProductsOrder productOrder=service.bookProductsOrder(order);
			log.info("Products Ordered booked Successful");
			return productOrder;
		}
		/*
		 *  @PutMaping Annotation for mapping HTTP PUT requests onto specific handler methods.
		 */
		/*
		 * @Path variable This is another annotation that is used to retrieve data from the URL
		 */
		/*
		 * http://localhost:8081/ProductsOrderController/updateProductOrder/{orderId}
		 */
		 @PutMapping("/updateProductOrder/{orderId}")
		 public ProductsOrder updateproductsOrder(@RequestBody ProductsOrder order,@PathVariable int orderId)
		 {
			 log.info("Products Ordered updated Successful");
			 return service.updateProductsOrder(order);
		 }
		/*
		 * @DeleteMaping Annotation for mapping HTTP DELETE requests onto specific handler methods.
		 */
		 /*
			 * http://localhost:8081/ProductsOrderController/cancelProductsOrder/{orderId}
			 */
		 @DeleteMapping("/cancelProductsOrder/{orderId}")
		 public ProductsOrder cancelProductOrder(@PathVariable int orderId)throws OrderIdNotFoundException
		 {
			 log.info("Products Ordered Cancelled Successful");
			 return service.cancelProductsOrder(orderId);
		 }
		/*
		 * @GetMapping Annotation for mapping HTTP GET requests onto specific handler methods.
		 */
		 /*
			 * http://localhost:8081/ProductsOrderController/viewProductsOrder/{orderId}
			 */
		 
		 @GetMapping("/viewProductsOrder/{orderId}")
		 public ProductsOrder viewProductsOrder(@PathVariable int orderId)throws OrderIdNotFoundException 
		 {
			 log.info("Products Ordered viewed Successful by Id");
			 return service.viewProductsOrder(orderId);
		 }
		 /*
			 * http://localhost:8081/ProductsOrderController/viewOrderList
			 */
		 @GetMapping("/viewOrderList")
		 public List<ProductsOrder> viewOrderList()
		 {
			 log.info("Products Ordered viewed Successful");
			 return service.viewOrdersList();
		 }
		 /*
			 * http://localhost:8081/ProductsOrderController/viewOrdersLists/{orderDate}
			 */
		 @GetMapping("/viewOrdersLists/{orderDate}")
		 public List<ProductsOrder> viewOrdersLists(@PathVariable String orderDate)
		 {
			 LocalDate d1=LocalDate.parse(orderDate);
			 log.info("Products Ordered viewed Successful by OrderDate");
			 return service.viewOrdersLists(d1);
		 }
		
}
	 

