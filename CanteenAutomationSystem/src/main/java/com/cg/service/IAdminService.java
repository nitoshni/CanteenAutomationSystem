package com.cg.service;

import java.util.List;

import com.cg.exception.AdminIdNotFoundException;
import com.cg.model.Admin;

public interface IAdminService {
	/* We are using Service package to implement curd operations....
	 * Like add,update,delete,view.
	 */
	
		public Admin addNewAdmin(Admin admin);
		 //adding admin details in the database.
		public Admin signIn(Admin admin) throws AdminIdNotFoundException;
		//admin is signIn and we are using AdminIdNotFoundException.
		public Admin signOut(Admin admin);
		//Admin is signOut.
		public Admin updateAdminPassword(Admin admin);
		//Admin is updating password.
		List<Admin> findByAdminName(String UserName);
		
	}
