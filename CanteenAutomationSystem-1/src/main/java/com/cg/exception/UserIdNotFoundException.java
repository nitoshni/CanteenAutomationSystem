package com.cg.exception;
/*
 * This is a user defined exception for UserId not found.
 */
public class UserIdNotFoundException extends Exception{
	public UserIdNotFoundException(String IdNotFound )
	{
		super(IdNotFound);
	}
}
