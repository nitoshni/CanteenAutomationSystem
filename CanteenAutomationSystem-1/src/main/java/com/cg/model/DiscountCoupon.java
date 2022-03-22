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
@Table(name="DiscountCoupon")


public class DiscountCoupon 
{
	/* @Id annotation specifies the primary key of an entity.
	 * @GeneratedValue provides for the specification of generation strategies for the values of primary keys.
	 * @Column annotation is used for adding the column name in the table in database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CouponId")
	private int couponId;
	@Column(name="CouponName")
	private String couponName;
	@Column(name="CouponType")
	private String couponType;
	@Column(name="CouponDescription")
	private String couponDescription;
	@Column(name="CouponProductsId")
	private int couponProductsId;
	/*
	 * Using getters and setters for all admin variables.
	 */

	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public String getCouponType() {
		return couponType;
	}
	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}
	public String getCouponDescription() {
		return couponDescription;
	}
	public void setCouponDescription(String couponDescription) {
		this.couponDescription = couponDescription;
	}
	public int getCouponPizzaId() {
		return couponProductsId;
	}
	public void setCouponPizzaId(int couponProductsId) {
		this.couponProductsId = couponProductsId;
	}
}
