package com.cg.service;

import com.cg.exception.UserIdNotFoundException;
import com.cg.model.User;

public interface IUserService {
	public User addNewUser(User user);
	/*
	 * adding User details in the database.
	 */
  
	public User signIn(User user) throws UserIdNotFoundException;
	/*
	 * User is signIn and we are using UserIdNotFoundException.
	 */
    
	public User signOut(User user);
	
	/*
	 * User is signOut.
	 */
  
	public User updatePassword(User user);
	/*
	 * User is updating password.
	 */
}