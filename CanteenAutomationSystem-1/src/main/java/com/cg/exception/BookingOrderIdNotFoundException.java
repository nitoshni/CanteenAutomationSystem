package com.cg.exception;
/*
 * This is a user defined exception for BookingOrderId not found.
 */
public class BookingOrderIdNotFoundException extends Exception{
	
	
	public BookingOrderIdNotFoundException(String IdNotFound )
	{
	super(IdNotFound);
	}
}
