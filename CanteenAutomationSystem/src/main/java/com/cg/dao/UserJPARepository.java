package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.model.User;


	//Indicates that an annotated class is a "Repository".This provide the transaction with db server.
	@Repository
	public interface UserJPARepository extends  JpaRepository<User, Integer>
	{
		/* We can use the JpaRepository interface from Spring framework,which provides a default implementation for the basic
		   CRUD operations.
		 * In order to define SQL to execute for a Spring Data repository method,we can annotate the method with the @Query.
		 * nativeQuery attribute contains the JPQL or SQL to execute.
		 */
		@Query(value="select user_name from User_Details where user_id=?1", nativeQuery=true )
		 public String getUserName(int getId);
		 @Query(value="select password from User_Details where user_id=?1", nativeQuery=true )
		 public String getUserPassword(int getId);
}
