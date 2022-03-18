package com.cg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.AdminIdNotFoundException;
import com.cg.model.Admin;
import com.cg.service.IAdminservice;

@RestController
public class AdminController {
@Autowired
private IAdminservice service;

 Logger log=LoggerFactory.getLogger(AdminController.class);
@PostMapping("/createAdmin")
public Admin addAdmin(@RequestBody Admin admin)
{
Admin ad=service.addNewAdmin(admin);
log.info("Admin Details Added Successful");
return ad;
}
@PostMapping(path ="/signIn")
public Admin signIn (@RequestBody Admin admin) throws AdminIdNotFoundException
{
System.out.println("sign in");
log.info("Admin SignIn Successful");
return service.signIn(admin);
}
@DeleteMapping(path="/signOut/{adminId}")
public Admin signOut(@RequestBody Admin admin ,@PathVariable int adminId)
{
log.info("Admin SignOut Successful");
return service.signOut(admin);
}
@PutMapping("/updateAdminPassword/{adminId}")
public Admin updatePassword(@RequestBody Admin admin ,@PathVariable int adminId )
{
log.info("Admin Password Updated Successful by Id");
return service.updateAdminPassword(admin);
}
}