package com.cg.dao;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface AdminJPArepository extends JpaRepository<Admin,Integer> {
@Query(value="select admin_user_name from Admin where admin_id=?1", nativeQuery=true )
public String getAdminUserName(int getId);
@Query(value="select admin_password from Admin where admin_id=?1", nativeQuery=true )
public String getAdminPassword(int getId);
}