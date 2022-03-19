package com.cg.model;

import java.time.LocalDate;

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
@Table(name="ProductOrder")
//@Table annotation gives the name of the table.
@JsonIgnoreProperties({"hibernateLazyInitializer"})
/* It allows Jackson to ignore the garbage created by Hibernate,
 * So it can manage the lazy loading of data as referred before.
 */
public class ProductsOrder 
{
	/* @Id annotation specifies the primary key of an entity.
	 * @GeneratedValue provides for the specification of generation strategies for the values of primary keys.
	 * @Column annotation is used for adding the column name in the table in database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="BookingOrderId")
	private int bookingOrderId;
	@Column(name="OrderDate")
	private LocalDate orderDate;
	@Column(name="TransactionMode")
	private String transactionMode;
	@Column(name="Quantity")
	private int quantity;
	@Column(name="TotalCost")
	private double totalCost;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ProductId")
	private Products Products;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OrderId")
	private  Order order;
	
	public int getBookingOrderId() {
		return bookingOrderId;
	}
	public void setBookingOrderId(int bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public Products getProducts() {
		return Products;
	}
	public void setProducts(Products products) {
		Products = products;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	/*@OneToOne annotation is used to create the one-to-one relationship between the entities and classes will map.
	 * @JoinColumn annotation is used to connect another table column with this table column.
	 * Using getters and setters for all product order variables.
	 */
	
}
