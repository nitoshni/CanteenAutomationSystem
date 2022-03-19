package com.cg.service;

import java.util.List;

import com.cg.model.CanteenStaff;
import com.cg.model.Customer;

/* We are using Service package to implement curd operations....
 * Like add,update,delete,view.
 */
public interface ICanteenStaffService 
{
	public CanteenStaff addCanteenStaff(CanteenStaff canteenstaff);
    //adding details in the database.
	public  CanteenStaff updateCanteenStaff(CanteenStaff canteenstaff);
    //updating details in customer table.
	public  CanteenStaff deleteCanteenStaff(int canteenstaffId);
    //deleting details in customer table by Id we are using CustomerIdNotFoundException.
	public CanteenStaff viewCanteenStaff(int canteenstaffId);
	//viewing customer details by Id we are using CustomerIdNotFoundException.
	Customer addCustomer(Customer customer);
}

