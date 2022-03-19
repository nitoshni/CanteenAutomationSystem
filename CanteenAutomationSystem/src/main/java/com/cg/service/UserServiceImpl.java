package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.dao.UserJPARepository;
import com.cg.model.User;


public class UserServiceImpl {
	@Autowired
	private UserJPARepository userRepo;

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	public User findUser(Integer userId) {
		Optional<User>user=userRepo.findById(userId); //predefined method
		return user.get();
	}
	public List<User> deleteUser(Integer userId) {
		userRepo.deleteById(userId);
		return  userRepo.findAll();
	}
	public List<User> saveProduct(User user) {
		userRepo.saveAndFlush(user);
		return  userRepo.findAll();
	}
	
	
	public User saveUser2(User user) {
	System.out.println("inside save2");
		return userRepo.save(user);
	}

	public List<User> updateUser(User user) {
		userRepo.saveAndFlush(user);
		return  userRepo.findAll();
	}

	public List<User> saveAll() {
		// TODO Auto-generated method stub
		return null;
	}	
}