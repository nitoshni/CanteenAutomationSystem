package com.cg.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.exception.CustomerIdNotFoundException;
import com.cg.model.Customer;
import com.cg.service.ICustomerService;

//@RestController This annotation for developing a RESTful web service with the Spring MVC framework.
@RestController
public class CustomerController {

//Spring @Autowired annotation is used for automatic injection of beans and Setter methods.
@Autowired
private ICustomerService service;


// @PostMapping annotated method handle the HTTP POST requests matched with given URI expression.
@PostMapping("/createCustomer")


//@RequestBody This annotation can convert in bound HTTP data into Java objects passed into the controller's handler method.
public Customer addCustomer(@RequestBody Customer customer)
{
Customer cust=service.addCustomer(customer);
System.out.println("Customer Details Added Successful");
return cust;
}

//@GetMapping Annotation for mapping HTTP GET requests onto specific handler methods.
@GetMapping("/getCustomers")
public List<Customer> viewCustomers()
{
	System.out.println("Customer Details viewed Successful");
return service.viewCustomers();
}

// @PutMaping Annotation for mapping HTTP PUT requests onto specific handler methods.
//@Path variable This is another annotation that is used to retrieve data from the URL
@PutMapping("/updateCustomer/{customerId}")
public Customer updateCustomer(@RequestBody Customer customer,@PathVariable int customerId)
{
	System.out.println("Customer Details Updated Successful by Id");
return service.updateCustomer(customer);
}


//@DeleteMaping Annotation for mapping HTTP DELETE requests onto specific handler methods.
@DeleteMapping("/deleteCustomer/{customerId}")
public Customer deleteCustomer(@PathVariable int customerId) throws CustomerIdNotFoundException
{
	System.out.println("Customer Details delete Successful by Id");
return service.deleteCustomer(customerId);
}


@GetMapping("/getCustomerById/{customerId}")
public Customer viewCustomer(@PathVariable int customerId) throws CustomerIdNotFoundException
{
	System.out.println("Customer Details viewed Successful by Id");
return service.viewCustomer(customerId);
}
}