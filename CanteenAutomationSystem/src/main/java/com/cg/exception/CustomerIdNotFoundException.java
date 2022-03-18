package com.cg.exception;

//This is a user defined exception for CustomerId not found.
public class CustomerIdNotFoundException extends Exception 
{
	
	public CustomerIdNotFoundException(String IdNotFound )
	{
		super(IdNotFound);
	}
}
