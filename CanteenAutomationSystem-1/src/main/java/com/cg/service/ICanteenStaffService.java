package com.cg.service;

import java.util.List;

import com.cg.exception.CanteenStaffIdNotFoundException;
import com.cg.model.CanteenStaff;

public interface ICanteenStaffService 
{
	public CanteenStaff addCanteenStaff(CanteenStaff canteenstaff);

/*
 * adding staff details in the database.
 */

	public  CanteenStaff updateCanteenStaff(CanteenStaff canteenstaff);
	/*
	 * updating the dtails in database we are using canteenstaffId exception.
	 */

	public  CanteenStaff deleteCanteenStaff(int canteenstaffId) throws CanteenStaffIdNotFoundException;
	/*
	 * deleting staff details.
	 */

	public CanteenStaff viewCanteenStaff(int canteenstaffId) throws CanteenStaffIdNotFoundException;

	/*
	 * viewing the staff details.
	 */

	public List<CanteenStaff> viewCanteenStaff();

}