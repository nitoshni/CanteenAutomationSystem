package com.cg.exception;

//This is a user defined exception for orderId not found.
public class OrderIdNotFoundException extends Exception 
{
	public OrderIdNotFoundException(String message) 
	{
		super(message);
	}
}
