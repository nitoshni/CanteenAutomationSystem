package com.cg.service;

import com.cg.exception.UserIdNotFoundException;
import com.cg.model.UserStaff;

public interface IUserStaffService {

	public UserStaff addNewUserStaff(UserStaff userStaff);
	/*
	 * adding UserStaff details in the database.
	 */  
	public UserStaff signIn(UserStaff userStaff) throws UserIdNotFoundException;
	/*
	 * UserStaff is signIn and we are using UserStaffIdNotFoundException.
	 */
    
	public UserStaff signOut(UserStaff userStaff);
	/*
	 * UserStaff is signOut.
	 */
  
	public UserStaff updatePassword(UserStaff userStaff);
	/*
	 * UserStaff is updating password.
	 */
}