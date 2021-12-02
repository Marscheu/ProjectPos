package com.projectdemo.pos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="order_id")
	private int order_id;
	
	@Column(name="order_total")
	private double order_total;
	
	@Column(name="order_cashier")
	private int order_cashier;
	
	public Orders() {
		
	}

	public Orders(int order_id, double order_total, int order_cashier) {
		super();
		this.order_id = order_id;
		this.order_total = order_total;
		this.order_cashier = order_cashier;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public double getOrder_total() {
		return order_total;
	}

	public void setOrder_total(double order_total) {
		this.order_total = order_total;
	}

	public int getOrder_cashier() {
		return order_cashier;
	}

	public void setOrder_cashier(int order_cashier) {
		this.order_cashier = order_cashier;
	}

	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", order_total=" + order_total + ", order_cashier=" + order_cashier
				+ "]";
	}

}
