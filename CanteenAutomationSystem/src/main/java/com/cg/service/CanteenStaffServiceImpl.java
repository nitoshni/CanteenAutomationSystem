package com.cg.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.CanteenStaffJPARepository;
import com.cg.model.CanteenStaff;
import com.cg.model.Customer;




@Service
public class CanteenStaffServiceImpl implements ICanteenStaffService {
@Autowired
private CanteenStaffJPARepository canteenstaffRepo;

public List<CanteenStaff> getAll(){
return canteenstaffRepo.findAll();
}

public CanteenStaff findCanteenStaff(int staffId) {
Optional<CanteenStaff>cust=canteenstaffRepo.findById(staffId);
return cust.get();
}

public List<CanteenStaff> deleteCanteenStaff(Integer staffId) {
	canteenstaffRepo.deleteById(staffId);
return canteenstaffRepo.findAll();
}

public List<CanteenStaff> saveCanteenStaff(CanteenStaff staff) {
	canteenstaffRepo.saveAndFlush(staff);
return canteenstaffRepo.findAll();
}

public CanteenStaff saveCanteenStaff2(CanteenStaff staff) {
System.out.println("inside save2");
return canteenstaffRepo.save(staff);
}



public List<CanteenStaff> updateCustomer1(CanteenStaff staff) {
	canteenstaffRepo.saveAndFlush(staff);
return canteenstaffRepo.findAll();
}
public List<CanteenStaff> findBycanteenstaffName(String staffname) {
List<CanteenStaff>cust=canteenstaffRepo.findByCanteenstaffName( staffname);//custom methods of repository
return cust;
}


@Override
public CanteenStaff addCanteenStaff(CanteenStaff canteenstaff) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public CanteenStaff updateCanteenStaff(CanteenStaff canteenstaff) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public CanteenStaff deleteCanteenStaff(int canteenstaffId) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public CanteenStaff viewCanteenStaff(int canteenstaffId) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Customer addCustomer(Customer customer) {
	// TODO Auto-generated method stub
	return null;
}




}