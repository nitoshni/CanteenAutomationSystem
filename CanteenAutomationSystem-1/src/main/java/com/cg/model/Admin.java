package com.cg.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Entity;



import javax.persistence.Table;
/*
 * @Entity annotation specifies that the class is an entity and is mapped to a database table.
 */
@Entity
/*
 * @Table annotation gives the name of the table.
 */
@Table(name="Admin")


public class Admin {
	/* @Id annotation specifies the primary key of an entity.
	 * @GeneratedValue provides for the specification of generation strategies for the values of primary keys.
	 * @Column annotation is used for adding the column name in the table in database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="UserId")
	private int userId;
	@Column(name="UserName")
	private String userName;
	@Column(name="Password")
	private String password;
	/*
	 * Using getters and setters for all admin variables.
	 */

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
