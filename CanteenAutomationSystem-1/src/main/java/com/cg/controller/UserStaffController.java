package com.cg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.UserIdNotFoundException;
import com.cg.model.UserStaff;
import com.cg.service.IUserStaffService;

/*
 * @RestController This annotation for developing a RESTful web service with the Spring MVC framework.
 */
@RestController
@RequestMapping("/UserStaffController")
public class UserStaffController {
	Logger log=LoggerFactory.getLogger(ProductsOrderController.class);
	
	/* Logger will help to Know the backgroung Process when the services are started,
	   when the service has stoped logger is default in SpringBoot.
	*/
	/*
	 * Spring @Autowired annotation is used for automatic injection of beans and Setter methods.
	 */
	@Autowired
	private IUserStaffService service;
	/*
	 * @PostMapping annotated method handle the HTTP POST requests matched with given URI expression.
	 */
	/*
	 * @RequestBody This annotation can convert in bound HTTP data into Java objects passed into the controller's hand
	 */
	/*
	 * http://localhost:8081/UserStaffController/createUserStaff
	 */
	@PostMapping("/createUserStaff")
	public UserStaff addUser(@RequestBody UserStaff userStaff)
	{
		UserStaff us=service.addNewUserStaff(userStaff);
		log.info("User Details Added Successful");
		return us;
	}
	/*
	 * http://localhost:8081/UserStaffController/UserStaffLogin
	 */
	@PostMapping(path = "/UserStafflogIn")
	public UserStaff signIn (@RequestBody UserStaff userStaff) throws UserIdNotFoundException
	{
		log.info("UserStaff signIn Successful");
		return service.signIn(userStaff);
	}
	/*
	 * @DeleteMaping Annotation for mapping HTTP DELETE requests onto specific handler methods.
	 */
	/*
	 * http://localhost:8081/UserStaffController/UserStaffLogout/{userstaffId}
	 */
	@DeleteMapping(path="/UserStafflogOut/{userstaffId}")
	public UserStaff signOut(@RequestBody UserStaff userStaff ,@PathVariable int userStaffId)
	{
		log.info("UserStaff LogOut Successful");
		return service.signOut(userStaff);
	}
	/*
	 * @PutMaping Annotation for mapping HTTP PUT requests onto specific handler methods.
	 */
	/*
	 * @Path variable This is another annotation that is used to retrieve data from the URL
	 */
	/*
	 * http://localhost:8081/UserStaffController/updateStaffPassword/{userstaffId}
	 */
	@PutMapping("/updateStaffPassword/{userstaffId}")
	public UserStaff updatePassword(@RequestBody UserStaff userStaff ,@PathVariable int userStaffId )
	{
		log.info("UserStaff Password Update Successful by Id");
		return service.updatePassword(userStaff);
	}

}	 