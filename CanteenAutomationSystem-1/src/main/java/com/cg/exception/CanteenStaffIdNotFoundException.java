package com.cg.exception;
/*
 * This is a user defined exception for CanteenStaffId not found.
 */
public class CanteenStaffIdNotFoundException extends Exception{
	public CanteenStaffIdNotFoundException (String IdNotFound )
	{
	super(IdNotFound);
	}

}
