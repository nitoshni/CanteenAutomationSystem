package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.UserStaffJPARepository;
import com.cg.exception.UserIdNotFoundException;
import com.cg.model.UserStaff;

/* Indicates that an annotated class is a “Service”.
This annotation serves as a specialization of @Component,
allowing for implementation classes to be autodetected through classpath scanning.
*/
@Service
public class UserStaffServiceImpl implements IUserStaffService{
	/*
	 * Spring @Autowired annotation is used for automatic injection of beans and Setter methods.
	 */
	@Autowired
	
	private UserStaffJPARepository repository;

	@Override
	/*
	 * @Override annotation methods which are not implemented this methods are used in Interface..
	 */
	public UserStaff addNewUserStaff(UserStaff userStaff) 
	{
		UserStaff us=repository.save(userStaff);
		return us;
	}

	@Override
	/*
	 * user staff sign in
	 */
	public UserStaff signIn(UserStaff userStaff) throws UserIdNotFoundException {
	
		String userName=userStaff.getUserName();
		String password=userStaff.getPassword();
		if((userName.equals(repository.getUserName(userStaff.getUserId())))&&(password.equals(repository.getUserPassword(userStaff.getUserId()))))
		{
		return repository.getById(userStaff.getUserId());
		}
		else
		{
		throw new UserIdNotFoundException("User not found in the database");
		}
	}

	@Override
	/*
	 * user staff signout
	 */
	public UserStaff signOut(UserStaff userStaff) 
	{
		UserStaff us=repository.getById(userStaff.getUserId());
		repository.delete(us);
		return us;
	}

	@Override
	/*
	 * updating password
	 */
	public UserStaff updatePassword(UserStaff userStaff) 
	{
		if(repository.existsById(userStaff.getUserId()))
		{
		  return repository.save(userStaff);
	    }
		return userStaff;
	}

}
