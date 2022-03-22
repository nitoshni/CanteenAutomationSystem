package com.cg.service;

import com.cg.exception.AdminIdNotFoundException;

import com.cg.model.Admin;


public interface IAdminService {
	public Admin addNewAdmin(Admin admin);
	/*
	 * adding admin details in the database.
	 */
	  
	public Admin signIn(Admin admin) throws  AdminIdNotFoundException;
	/*
	 * admin is signIn and we are using AdminIdNotFoundException.
	 */
    
	public Admin signOut(Admin admin);
	/*
	 * Admin is signOut.
	 */
  
	public Admin updatePassword(Admin admin);
	/*
	 * Admin is updating password.
	 */
	

}
