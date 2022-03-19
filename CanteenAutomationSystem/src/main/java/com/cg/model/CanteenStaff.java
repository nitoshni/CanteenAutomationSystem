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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
//@Entity annotation specifies that the class is an entity and is mapped to a database table.
@Table(name="Staff_details")
//@Table annotation gives the name of the table.
@JsonIgnoreProperties({"hibernateLazyInitializer"})
/* It allows Jackson to ignore the garbage created by Hibernate,
 * So it can manage the lazy loading of data as referred before.
 */
public class CanteenStaff {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="StaffId")
	private int staffId;
	@Column(name="StaffName")
	private String staffName;
	@Column(name="StaffCounter")
	private String staffCounter;
	@Column(name="StaffEmail")
	private String customerEmail;
	
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
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
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
	/*@OneToOne annotation is used to create the one-to-one relationship between the entities and classes will map.
	 * @JoinColumn annotation is used to connect another table column with this table column.
	 * Using getters and setters for all customer variables.
	 */
	
}
