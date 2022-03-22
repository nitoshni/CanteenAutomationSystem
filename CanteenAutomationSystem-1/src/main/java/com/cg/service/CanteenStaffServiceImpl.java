package com.cg.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.CanteenStaffJPARepository;
import com.cg.exception.CanteenStaffIdNotFoundException;
import com.cg.model.CanteenStaff;


/* Indicates that an annotated class is a “Service”.
This annotation serves as a specialization of @Component,
allowing for implementation classes to be autodetected through classpath scanning.
*/
@Service
public class CanteenStaffServiceImpl implements ICanteenStaffService {
	/*
	 * Spring @Autowired annotation is used for automatic injection of beans and Setter methods.
	 */
	@Autowired
	private CanteenStaffJPARepository repository;
	/*
	 * @Override annotation methods which are not implemented this methods are used in Interface..
	 */
	@Override
	/*
	 * adding canteenstaff details
	 */
	public CanteenStaff addCanteenStaff(CanteenStaff canteenStaff) 
	{
		CanteenStaff cust=repository.save(canteenStaff);
		return cust;
	}

	@Override
	/*
	 * updating canteenstaff details
	 */
	public CanteenStaff updateCanteenStaff(CanteenStaff canteenStaff) {
		CanteenStaff canteenStaff1=repository.getById(canteenStaff.getStaffId());
		return repository.save(canteenStaff);
	}

	@Override
	/*
	 * deleting canteenstaff details
	 */
	public CanteenStaff deleteCanteenStaff(int canteenStaffId) throws CanteenStaffIdNotFoundException {
		if(repository.existsById(canteenStaffId))
		{
			CanteenStaff cust1=repository.getById(canteenStaffId);
			repository.delete(cust1);
			return cust1;
		}
		else
		{
			throw new CanteenStaffIdNotFoundException("canteenStaff is not found in the database");
		}
	}
	@Override
	/*
	 * viewing the canteenstaff details
	 */
	public List<CanteenStaff> viewCanteenStaff() 
	{
		List<CanteenStaff> listCanteenStaff=repository.findAll();
		return listCanteenStaff;
	}

	@Override
	public CanteenStaff viewCanteenStaff(int canteenStaffId) throws CanteenStaffIdNotFoundException 
	{
		Optional<CanteenStaff> found=repository.findById(canteenStaffId);
		if(found.isPresent())
		{
			return found.get();
		}
		else
		{
			throw new CanteenStaffIdNotFoundException("canteenStaffId is not exits");
		}
	}

}

