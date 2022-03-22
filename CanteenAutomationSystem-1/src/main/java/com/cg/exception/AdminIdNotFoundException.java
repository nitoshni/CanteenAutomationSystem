package com.cg.exception;
/*
 * This is a user defined exception for AdminId not found.
 */
public class AdminIdNotFoundException extends Exception
{

	public  AdminIdNotFoundException(String IdNotFound )
	{
		super(IdNotFound);
	}
} 

