package com.cg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * @Entity annotation specifies that the class is an entity and is mapped to a database table.
 */
@Entity

/*
 * @Table annotation gives the name of the table.
 */
@Table(name="staff_user_details")

public class UserStaff {
	/* @Id annotation specifies the primary key of an entity.
	 * @GeneratedValue provides for the specification of generation strategies for the values of primary keys.
	 * @Column annotation is used for adding the column name in the table in database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="UserStaffId")
	private int userStaffId;
	@Column(name="UserStaffName")
	private String userStaffName;
	@Column(name="StaffPassword")
	private String staffpassword;
	/*
	 * Using getters and setters for all admin variables.
	 */

	public int getUserId() {
		return getUserId();
	}
	public void setUserId(int userId) {
		this.userStaffId = userId;
	}
	public String getUserName() {
		return userStaffName;
	}
	public void setUserName(String userName) {
		this.userStaffName = userName;
	}
	public String getPassword() {
		return staffpassword;
	}
	public void setPassword(String password) {
		this.staffpassword = password;
	}

}
