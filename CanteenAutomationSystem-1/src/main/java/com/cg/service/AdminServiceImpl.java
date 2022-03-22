package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.AdminJpaReposistory;
import com.cg.exception.AdminIdNotFoundException;
import com.cg.model.Admin;

/* Indicates that an annotated class is a “Service”.
This annotation serves as a specialization of @Component,
allowing for implementation classes to be autodetected through classpath scanning.
*/
@Service
public class AdminServiceImpl  implements IAdminService{
	/*
	 * Spring @Autowired annotation is used for automatic injection of beans and Setter methods.
	 */
	@Autowired
	
	
	private AdminJpaReposistory repository;

	@Override
	/*
	 * @Override annotation methods which are not implemented this methods are used in Interface..
	 */
	/*
	 * adding admin details
	 */
	public Admin addNewAdmin(Admin admin) 
	{
		Admin us=repository.save(admin);
		return us;
	}

	@Override
	/*
	 * sign in admin
	 */
	public Admin signIn(Admin admin) throws AdminIdNotFoundException {
	
		String userName=admin.getUserName();
		String password=admin.getPassword();
		if((userName.equals(repository.getUserName(admin.getUserId())))&&(password.equals(repository.getUserPassword(admin.getUserId()))))
		{
		return repository.getById(admin.getUserId());
		}
		else
		{
		throw new AdminIdNotFoundException("User not found in the database");
		}
	}

	@Override
	/*
	 * admin signout
	 */
	public Admin signOut(Admin admin) 
	{
		Admin us=repository.getById(admin.getUserId());
		repository.delete(us);
		return us;
	}

	@Override
	/*
	 * update admin
	 */
	public Admin updatePassword(Admin admin) 
	{
		if(repository.existsById(admin.getUserId()))
		{
		  return repository.save(admin);
	    }
		return admin;
	}
}
