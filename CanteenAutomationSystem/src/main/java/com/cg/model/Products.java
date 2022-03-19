package com.cg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//@Entity annotation specifies that the class is an entity and is mapped to a database table.
@Table(name="products")
//@Table annotation gives the name of the table.
@JsonIgnoreProperties({"hibernateLazyInitializer"})
/* It allows Jackson to ignore the garbage created by Hibernate,
 * So it can manage the lazy loading of data as referred before.
 */
public class Products {
	/* @Id annotation specifies the primary key of an entity.
	 * @GeneratedValue provides for the specification of generation strategies for the values of primary keys.
	 * @Column annotation is used for adding the column name in the table in database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ProductId")
	private int productId;
	@Column(name="ProductType")
	private String productType;
	@Column(name="ProductName")
	private String productName;
	
	@Column(name="ProductCost")
	private double productCost;
	@Column(name="ProductCostAfterDiscount")
	private double productCostAfterDiscount;
	//Using getters and setters for all pizza variables.
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductCost() {
		return productCost;
	}
	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}
	public double getProductCostAfterDiscount() {
		return productCostAfterDiscount;
	}
	public void setProductCostAfterDiscount(double productCostAfterDiscount) {
		this.productCostAfterDiscount = productCostAfterDiscount;
	}
	
}