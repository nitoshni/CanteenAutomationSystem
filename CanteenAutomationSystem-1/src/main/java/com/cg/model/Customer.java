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
@Table(name="customer_details")


public class Customer
{
	/* @Id annotation specifies the primary key of an entity.
	 * @GeneratedValue provides for the specification of generation strategies for the values of primary keys.
	 * @Column annotation is used for adding the column name in the table in database.
	 */

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="CustomerId")
private int customerId;

@Column(name="CustomerName")
private String customerName;

@Column(name="CustomerMobileNo")
private Long customerMobileNo;

@Column(name="CustomerAddress")
private String customerAddress;

@Column(name="UserName")
private String userName;

@Column(name="Password")
private String password;
/*@OneToOne annotation is used to create the one-to-one relationship between the entities and classes will map.
 * @JoinColumn annotation is used to connect another table column with this table column.
 * Using getters and setters for all customer variables.
 */

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="BookingOrderId")
private ProductsOrder custOrder;
/*
 * Using getters and setters for all admin variables.
 */


public int getCustomerId() {
return customerId;
}
public void setCustomerId(int customerId) {
this.customerId = customerId;
}
public String getCustomerName() {
return customerName;
}
public void setCustomerName(String customerName) {
this.customerName = customerName;
}
public Long getCustomerMobileNo() {
return customerMobileNo;
}
public void setCustomerMobileNo(Long customerMobileNo) {
this.customerMobileNo = customerMobileNo;
}
public String getCustomerAddress() {
return customerAddress;
}
public void setCustomerAddress(String customerAddress) {
this.customerAddress = customerAddress;
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

