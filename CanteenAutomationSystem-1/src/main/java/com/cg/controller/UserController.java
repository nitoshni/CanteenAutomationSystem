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
import com.cg.model.User;
import com.cg.service.IUserService;

/*
 * @RestController This annotation for developing a RESTful web service with the Spring MVC framework.
 */
@RestController
@RequestMapping("/UserController")
public class UserController 
{
	
	/* Logger will help to Know the backgroung Process when the services are started,
	   when the service has stoped logger is default in SpringBoot.
	*/
	Logger log=LoggerFactory.getLogger(UserController.class);
	/*
	 * Spring @Autowired annotation is used for automatic injection of beans and Setter methods.
	 */
		@Autowired
		private IUserService service;
		/*
		 * @PostMapping annotated method handle the HTTP POST requests matched with given URI expression.
		 */


		/*
		 * @RequestBody This annotation can convert in bound HTTP data into Java objects passed into the controller's hand
		 */
		/*
		 * http://localhost:8081/UserController/createUser
		 */
		@PostMapping("/createUser")
		public User addUser(@RequestBody User user)
		{
			User us=service.addNewUser(user);
			log.info("User Details Added Successful");
			return us;
		}
		/*
		 * http://localhost:8081/UserController/UserLogIn
		 */
		@PostMapping(path = "/UserlogIn")
		public User signIn (@RequestBody User user) throws UserIdNotFoundException
		{
			log.info("User signIn Successful");
			return service.signIn(user);
		}
		/*
		 * @DeleteMaping Annotation for mapping HTTP DELETE requests onto specific handler methods.
		 */
		/*
		 * http://localhost:8081/UserController/UserLogout/{userId}
		 */
		@DeleteMapping(path="/UserlogOut/{userId}")
		public User signOut(@RequestBody User user ,@PathVariable int userId)
		{
			log.info("User LogOut Successful");
			return service.signOut(user);
		}

		/*
		 * @PutMaping Annotation for mapping HTTP PUT requests onto specific handler methods.
		 */
		/*
		 * @Path variable This is another annotation that is used to retrieve data from the URL
		 */
		/*
		 * http://localhost:8081/UserController/updateUserPassword/{userId}
		 */
		@PutMapping("/updateUserPassword/{userId}")
		public User updatePassword(@RequestBody User user ,@PathVariable int userId )
		{
			log.info("User Password Update Successful by Id");
			return service.updatePassword(user);
		}
	}