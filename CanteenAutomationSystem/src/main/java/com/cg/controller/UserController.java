package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.UserIdNotFoundException;
import com.cg.model.User;
import com.cg.service.IUserService;


@RestController
public class UserController {

		//Spring @Autowired annotation is used for automatic injection of beans and Setter methods. 
		@Autowired
		private IUserService service;
		
		// @PostMapping annotated method handle the HTTP POST requests matched with given URI expression.
		//@RequestBody This annotation can convert inbound HTTP data into Java objects passed into the controller's handler method.
		@PostMapping("/createUser")
		public User addUser(@RequestBody User user)
		{
			User us=service.addNewUser(user);
			System.out.println("User Details Added Successful");
			return us;
		}
		@PostMapping(path = "/logIn")
		public User signIn (@RequestBody User user) throws UserIdNotFoundException
		{
			System.out.println("sign in");
			System.out.println("User signIn Successful");
			return service.signIn(user);
		}
		//@DeleteMaping Annotation for mapping HTTP DELETE requests onto specific handler methods.
		@DeleteMapping(path="/logOut/{userId}")
		public User signOut(@RequestBody User user ,@PathVariable int userId)
		{
			System.out.println("User LogOut Successful");
			return service.signOut(user);
		}
		//@PutMaping Annotation for mapping HTTP PUT requests onto specific handler methods.
		//@Path variable This is another annotation that is used to retrieve data from the URL
		@PutMapping("/updatePassword/{userId}")
		public User updatePassword(@RequestBody User user ,@PathVariable int userId )
		{
			System.out.println("User Password Update Successful by Id");
			return service.updatePassword(user);
		}
	}



