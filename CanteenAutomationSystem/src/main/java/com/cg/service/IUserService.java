package com.cg.service;

import com.cg.exception.UserIdNotFoundException;
import com.cg.model.User;

public interface IUserService {
	public User addNewUser(User user);
    //adding user details in the database.
	public User signIn(User user) throws UserIdNotFoundException;
    //user is signIn and we are using UserIdNotFoundException.
	public User signOut(User user);
    //user is signOut.
	public User updatePassword(User user);
	//user is updating password.

}