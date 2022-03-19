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
import com.cg.dao.CanteenStaffJPARepository;
import com.cg.exception.CanteenStaffIdNotFoundException;
import com.cg.model.CanteenStaff;


//@RestController This annotation for developing a RESTful web service with the Spring MVC framework.
@RestController
public class CanteenStaffController {

//Spring @Autowired annotation is used for automatic injection of beans and Setter methods.
@Autowired
private CanteenStaffJPARepository service;

// @PostMapping annotated method handle the HTTP POST requests matched with given URI expression.
@PostMapping("/createCanteenStaff")

//@RequestBody This annotation can convert in bound HTTP data into Java objects passed into the controller's handler method.
public CanteenStaff addCanteenStaff(@RequestBody CanteenStaff canteenstaff)
{
	CanteenStaff cust=(CanteenStaff) service.addCanteenstaff(canteenstaff);
	System.out.println("CanteenStaff Details Added Successful");
	return cust;
}

//@GetMapping Annotation for mapping HTTP GET requests onto specific handler methods.
@GetMapping("/getCanteenStaff")
public List<CanteenStaff> viewCanteenStaff()
{
	System.out.println("CanteenStaff Details viewed Successful");
return service.viewCanteenstaff();
}

// @PutMaping Annotation for mapping HTTP PUT requests onto specific handler methods.
//@Path variable This is another annotation that is used to retrieve data from the URL
@PutMapping("/updateCanteenStaff/{CanteenStaffId}")
public List<CanteenStaff> updateCanteenStaff(@RequestBody CanteenStaff canteenstaff,@PathVariable int canteenstaffId)
{
	System.out.println("CanteenStaff Details Updated Successful by Id");
return service.updateCanteenstaff(canteenstaff);
}

//@DeleteMaping Annotation for mapping HTTP DELETE requests onto specific handler methods.
@DeleteMapping("/deleteCanteenStaff/{CanteenStaffId}")
public List<CanteenStaff> deleteCanteenStaff(@PathVariable int canteenstaffId) throws CanteenStaffIdNotFoundException
{
	System.out.println("CanteenStaff Details delete Successful by Id");
return service.deleteCanteenstaff(canteenstaffId);
}


@GetMapping("/getCanteenStaffById/{CanteenStaffId}")
public List<CanteenStaff> viewCanteenStaff(@PathVariable int CanteenStaffId) throws CanteenStaffIdNotFoundException

{
	System.out.println("CanteenStaff Details viewed Successful by Id");
return service.viewCanteenstaff(CanteenStaffId);
}
}