package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.UserJPARepository;
import com.cg.exception.UserIdNotFoundException;
import com.cg.model.User;
/* Indicates that an annotated class is a “Service”.
This annotation serves as a specialization of @Component,
allowing for implementation classes to be autodetected through classpath scanning.
*/
@Service
public class UserServiceImpl implements IUserService{
	/*
	 * Spring @Autowired annotation is used for automatic injection of beans and Setter methods.
	 */
		@Autowired
		private UserJPARepository repository;
		/*
		 * @Override annotation methods which are not implemented this methods are used in Interface..
		 */
		@Override
		/*
		 * adding user
		 */
		public User addNewUser(User user) 
		{
			User us=repository.save(user);
			return us;
		}

		@Override
		/*
		 * signin user
		 */
		public User signIn(User user) throws UserIdNotFoundException {
		
			String userName=user.getUserName();
			String password=user.getPassword();
			if((userName.equals(repository.getUserName(user.getUserId())))&&(password.equals(repository.getUserPassword(user.getUserId()))))
			{
			return repository.getById(user.getUserId());
			}
			else
			{
			throw new UserIdNotFoundException("User not found in the database");
			}
		}

		@Override
		/*
		 * user signout
		 */
		public User signOut(User user) 
		{
			User us=repository.getById(user.getUserId());
			repository.delete(us);
			return us;
		}

		@Override
		/*
		 * updating password
		 */
		public User updatePassword(User user) 
		{
			if(repository.existsById(user.getUserId()))
			{
			  return repository.save(user);
		    }
			return user;
		}
}

