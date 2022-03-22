package com.cg.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.model.CanteenStaff;




/*
 * Indicates that an annotated class is a "Repository".This provide the transaction with db server. 
 */
	@Repository
	public interface CanteenStaffJPARepository extends JpaRepository<CanteenStaff, Integer> {
		/* We can use the JpaRepository interface from Spring framework,which provides a default implementation for the basic
		   CRUD operations.
		 * In order to define SQL to execute for a Spring Data repository method,we can annotate the method with the @Query.
		 * nativeQuery attribute contains the JPQL or SQL to execute.
		 */
		
	@Query(value="select * from  CanteenStaffwhere CanteenStaffname=?1",nativeQuery = true)
	public List<CanteenStaff> findByCanteenstaffName(String canteenstaffName);
	
	@Query(value="select * from CanteenStaff where CanteenStaff_id=?1",nativeQuery = true)
	public List<CanteenStaff> addCanteenstaff(CanteenStaff canteenstaff);
	
	@Query(value="select * from CanteenStaff where CanteenStaff_id=?1",nativeQuery = true)
	public List<CanteenStaff> viewCanteenstaff();
	
	@Query(value="select * from CanteenStaff where CanteenStaff_id=?1",nativeQuery = true)
	public List<CanteenStaff> updateCanteenstaff(CanteenStaff canteenstaff);
	
	@Query(value="select * from CanteenStaff where CanteenStaff_id=?1",nativeQuery = true)
	public List<CanteenStaff> deleteCanteenstaff(int canteenstaffId);
	
	@Query(value="select * from CanteenStaff where CanteenStaff_id=?1",nativeQuery = true)
	public List<CanteenStaff> viewCanteenstaff(int canteenstaffId);



}


