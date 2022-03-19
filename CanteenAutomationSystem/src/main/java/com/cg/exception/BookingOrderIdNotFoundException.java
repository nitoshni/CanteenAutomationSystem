package com.cg.exception;

public class BookingOrderIdNotFoundException extends Exception{
	
	
	public BookingOrderIdNotFoundException(String IdNotFound )
	{
	super(IdNotFound);
	}
}
