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
@Table(name="customers")
//@Table annotation gives the name of the table.
@JsonIgnoreProperties({"hibernateLazyInitializer"})
/* It allows Jack son to ignore the garbage created by Hibernate,
* So it can manage the lazy loading of data as referred before.
*/
public class Customer
{

@Id // @Id annotation specifies the primary key of an entity.
@GeneratedValue(strategy = GenerationType.AUTO)// @GeneratedValue provides for the specification of generation strategies for the values of primary keys.
@Column(name="CustomerId")//@Column annotation is used for adding the column name in the table in database.
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

@OneToOne(cascade = CascadeType.ALL)//@OneToOne annotation is used to create the one-to-one relationship between the entities and classes will map.
@JoinColumn(name="BookingOrderId")//@JoinColumn annotation is used to connect another table column with this table column.
private Customer custOrder;//(check it)

//Using getters and setters for all customer variables.

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