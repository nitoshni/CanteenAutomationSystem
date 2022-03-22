package com.cg.controller;

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

import com.cg.exception.CanteenStaffIdNotFoundException;
import com.cg.model.CanteenStaff;
import com.cg.service.ICanteenStaffService;

/*
 * @RestController This annotation for developing a RESTful web service with the Spring MVC framework.
 */
@RestController
@RequestMapping("/CanteenStaffController")
public class CanteenStaffController {
	/* Logger will help to Know the backgroung Process when the services are started,
	   when the service has stoped logger is default in SpringBoot.
	*/
	Logger log=LoggerFactory.getLogger(CanteenStaffController.class);
	/*
	 * Spring @Autowired annotation is used for automatic injection of beans and Setter methods.
	 */
@Autowired
private ICanteenStaffService service;
/*
 * @PostMapping annotated method handle the HTTP POST requests matched with given URI expression.
 */
/*
 * @RequestBody This annotation can convert in bound HTTP data into Java objects passed into the controller's handler method.
 */
@PostMapping("/createCanteenStaff")
/*
 * http://localhost:8081/CanteenStaffController/createCanteenStaff
 */

public CanteenStaff addCanteenStaff(@RequestBody CanteenStaff canteenstaff)
{
	CanteenStaff cust=(CanteenStaff) service.addCanteenStaff(canteenstaff);
	log.info("CanteenStaff Details Added Successful");
	return cust;
}

/*
 * @GetMapping Annotation for mapping HTTP GET requests onto specific handler methods.
 */
@GetMapping("/getCanteenStaff")
/*
 * http://localhost:8081/CsnteenStaffController/getCanteenStaff
 */
public List<CanteenStaff> viewCanteenStaff()
{
	log.info("CanteenStaff Details viewed Successful");
return service.viewCanteenStaff();
}

/*
 * @PutMaping Annotation for mapping HTTP PUT requests onto specific handler methods.
 */
/*
 * @Path variable This is another annotation that is used to retrieve data from the URL
 */
/*
 * http://localhost:8081/CanteenStaffController/updateCanteenStaff/{CanteenStaffId}
 */
@PutMapping("/updateCanteenStaff/{CanteenStaffId}")
public CanteenStaff updateCanteenStaff(@RequestBody CanteenStaff canteenstaff,@PathVariable int canteenstaffId)
{
	log.info("CanteenStaff Details Updated Successful by Id");
return service.updateCanteenStaff(canteenstaff);
}

/*
 *  @DeleteMaping Annotation for mapping HTTP DELETE requests onto specific handler methods.
 */
/*
 * http://localhost:8081/ProductsController/products
 */
@DeleteMapping("/deleteCanteenStaff/{CanteenStaffId}")
public CanteenStaff deleteCanteenStaff(@PathVariable int canteenstaffId) throws CanteenStaffIdNotFoundException
{
	log.info("CanteenStaff Details delete Successful by Id");
return service.deleteCanteenStaff(canteenstaffId);
}

/*
 * @GetMapping Annotation for mapping HTTP GET requests onto specific handler methods.
 */
/*
 * http://localhost:8081/ProductsController/products
 */
@GetMapping("/getCanteenStaffById/{CanteenStaffId}")
public CanteenStaff viewCanteenStaff(@PathVariable int CanteenStaffId) throws CanteenStaffIdNotFoundException
{
	log.info("CanteenStaff Details viewed Successful by Id");
return service.viewCanteenStaff(CanteenStaffId);
}

}