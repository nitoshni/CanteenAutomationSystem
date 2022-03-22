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
@Table(name="products")

public class Products {
	/* @Id annotation specifies the primary key of an entity.
	 * @GeneratedValue provides for the specification of generation strategies for the values of primary keys.
	 * @Column annotation is used for adding the column name in the table in database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ProductsId")
	private int productsId;
	@Column(name="ProductsType")
	private String productsType;
	@Column(name="ProductsName")
	private String productsName;
	
	@Column(name="ProductsCost")
	private double productsCost;
	/*
	 * Using getters and setters for all admin variables.
	 */
	
	
	public int getProductsId() {
		return productsId;
	}
	public void setProductsId(int productsId) {
		this.productsId = productsId;
	}
	public String getProductsType() {
		return productsType;
	}
	public void setProductsType(String productsType) {
		this.productsType = productsType;
	}
	public String getProductsName() {
		return productsName;
	}
	public void setProductsName(String productsName) {
		this.productsName = productsName;
	}
	public double getProductsCost() {
		return productsCost;
	}
	public void setProductsCost(double productCost) {
		this.productsCost = productCost;
	}
	
	
}
