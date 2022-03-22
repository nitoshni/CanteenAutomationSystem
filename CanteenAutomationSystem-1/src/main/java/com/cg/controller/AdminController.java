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

import com.cg.exception.AdminIdNotFoundException;
import com.cg.model.Admin;
import com.cg.service.IAdminService;

/*
 * @RestController This annotation for developing a RESTful web service with the Spring MVC framework.
 */
@RequestMapping("/AdminController")
@RestController
public class AdminController {
	/* Logger will help to Know the backgroung Process when the services are started,
	   when the service has stoped logger is default in SpringBoot.
	*/
	Logger log=LoggerFactory.getLogger(AdminController.class);
	/*
	 * Spring @Autowired annotation is used for automatic injection of beans and Setter methods.
	 */
	@Autowired
	private IAdminService service;
	/*
	 * @PostMapping annotated method handle the HTTP POST requests matched with given URI expression.
	 */
	/*
	 * http://localhost:8081/ProductsController/createAdmin
	 */
	@PostMapping("/createAdmin")
	public Admin addAdmin(@RequestBody Admin admin)
	{
		Admin us=service.addNewAdmin(admin);
		log.info("Admin is created");
		return us;
	}
	/*
	 * http://localhost:8081/AdminController/AdminlogIn
	 */
	@PostMapping(path = "/AdminlogIn")
	public Admin signIn (@RequestBody Admin admin) throws AdminIdNotFoundException
	{
		log.info("Login succefull");
		return service.signIn(admin);
	}
	/*
	 * @DeleteMaping Annotation for mapping HTTP DELETE requests onto specific handler methods.
	 */
	/*
	 * http://localhost:8081/AdminCOntroller/Adminlogout/{userId}
	 */
	@DeleteMapping(path="/AdminlogOut/{userId}")
	public Admin signOut(@RequestBody Admin admin ,@PathVariable int userId)
	{
		log.info("logout successfull");
		return service.signOut(admin);
	}

	/*
	 * @PutMaping Annotation for mapping HTTP PUT requests onto specific handler methods.
	 */
	/*
	 * @Path variable This is another annotation that is used to retrieve data from the URL
	 */
	/*
	 * http://localhost:8081/AdminController/updateAdminPassword/
	 */
	@PutMapping("/updateAdminPassword/{userId}")
	public Admin updatePassword(@RequestBody Admin admin ,@PathVariable int userId )
	{
		log.info("update password successfull");
		return service.updatePassword(admin);
	}
}

