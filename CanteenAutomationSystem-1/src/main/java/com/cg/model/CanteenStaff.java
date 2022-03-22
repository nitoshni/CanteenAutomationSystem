package com.cg.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/*
 * @Entity annotation specifies that the class is an entity and is mapped to a database table.
 */
@Entity
/*
 * @Table annotation gives the name of the table.
 */
@Table(name="Staff_details")


public class CanteenStaff 
{
	/* @Id annotation specifies the primary key of an entity.
	 * @GeneratedValue provides for the specification of generation strategies for the values of primary keys.
	 * @Column annotation is used for adding the column name in the table in database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="StaffId")
	private int staffId;
	@Column(name="StaffName")
	private String staffName;
	@Column(name="StaffCounter")
	private String staffCounter;
	@Column(name="StaffEmail")
	private String staffEmail;
	/*
	 * Using getters and setters for all admin variables.
	 */
	
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getCustomerEmail() {
		return staffEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.staffEmail = customerEmail;
	}
	public String getStaffuserName() {
		return staffuserName;
	}
	public void setStaffuserName(String staffuserName) {
		this.staffuserName = staffuserName;
	}
	public String getStaffpassword() {
		return staffpassword;
	}
	public void setStaffpassword(String staffpassword) {
		this.staffpassword = staffpassword;
	}
	public ProductsOrder getProductOrder() {
		return productOrder;
	}
	public void setProductOrder(ProductsOrder productOrder) {
		this.productOrder = productOrder;
	}
	@Column(name="StaffUserName")
	private String staffuserName;
	@Column(name="StaffPassword")
	private String staffpassword;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="BookingOrderId")
	private ProductsOrder productOrder;
	
}
