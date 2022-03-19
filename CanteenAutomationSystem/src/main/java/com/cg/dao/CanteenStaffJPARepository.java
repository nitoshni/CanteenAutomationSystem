package com.cg.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.model.CanteenStaff;

@Repository
	public interface CanteenStaffJPARepository extends JpaRepository<CanteenStaff, Integer> {
		
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


