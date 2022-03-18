package com.cg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Admin")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Admin {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="admin_id")
private int admin_id;
@Column(name="admin_username")
private int admin_username;
@Column(name="admin_password")
private int admin_password;
public int getAdmin_id() {
return admin_id;
}
public void setAdmin_id(int admin_id) {
this.admin_id = admin_id;
}
public int getAdmin_username() {
return admin_username;
}
public void setAdmin_username(int admin_username) {
this.admin_username = admin_username;
}
public int getAdmin_password() {
return admin_password;
}
public void setAdmin_password(int admin_password) {
this.admin_password = admin_password;
}
}