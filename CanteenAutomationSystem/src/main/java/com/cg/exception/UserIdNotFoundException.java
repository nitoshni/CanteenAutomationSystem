package com.cg.exception;

public class UserIdNotFoundException extends Exception{
	public UserIdNotFoundException(String IdNotFound )
	{
		super(IdNotFound);
	}
}
