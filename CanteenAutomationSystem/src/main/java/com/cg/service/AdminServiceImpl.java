package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.AdminJPARepository;
import com.cg.exception.AdminIdNotFoundException;
import com.cg.model.Admin;

@Service
public  class AdminServiceImpl implements IAdminService{
@Autowired
private AdminJPARepository adminRepo;

public List<Admin> getAdmin(){
return adminRepo.find();
}
public Admin findAdmin(Integer AdminId) {
Optional<Admin>cust=adminRepo.findById(AdminId);
return cust.get();
}

public List<Admin> deleteAdmin(Integer AdminId) {
adminRepo.deleteById(AdminId);
return adminRepo.findAll();
}

public List<Admin> saveAdmin(Admin admin) {
adminRepo.saveAndFlush(admin);
return adminRepo.findAll();
}

public List<Admin> updateAdmin1(Admin admin) {
adminRepo.saveAndFlush(admin);
return adminRepo.findAll();
}

public List<Admin> saveAll() {
return null;
}

@Override
public List<Admin> findByAdminName(String UserName) {
List<Admin>cust=adminRepo.findByAdminName( UserName);
return cust;
}
@Override
public Admin addNewAdmin(Admin admin) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Admin signIn(Admin admin) throws AdminIdNotFoundException {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Admin signOut(Admin admin) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Admin updateAdminPassword(Admin admin) {
	// TODO Auto-generated method stub
	return null;
}
}