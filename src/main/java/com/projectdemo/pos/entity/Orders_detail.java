package com.projectdemo.pos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders_detail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="order_detail_id")
	private int order_detail_id;
	
	@Column(name="order_item")
	private int order_item;
	
	@Column(name="order_price")
	private double order_price;
	
	@Column(name="order_quantity")
	private double order_quantity;
	
	@Column(name="order_amount")
	private double order_amount;
	
	public Orders_detail() {
		
	}

	public Orders_detail(int order_detail_id, int order_item, double order_price, double order_quantity,
			double order_amount) {
		super();
		this.order_detail_id = order_detail_id;
		this.order_item = order_item;
		this.order_price = order_price;
		this.order_quantity = order_quantity;
		this.order_amount = order_amount;
	}

	public int getOrder_detail_id() {
		return order_detail_id;
	}

	public void setOrder_detail_id(int order_detail_id) {
		this.order_detail_id = order_detail_id;
	}

	public int getOrder_item() {
		return order_item;
	}

	public void setOrder_item(int order_item) {
		this.order_item = order_item;
	}

	public double getOrder_price() {
		return order_price;
	}

	public void setOrder_price(double order_price) {
		this.order_price = order_price;
	}

	public double getOrder_quantity() {
		return order_quantity;
	}

	public void setOrder_quantity(double order_quantity) {
		this.order_quantity = order_quantity;
	}

	public double getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(double order_amount) {
		this.order_amount = order_amount;
	}

	@Override
	public String toString() {
		return "Orders_detail [order_detail_id=" + order_detail_id + ", order_item=" + order_item + ", order_price="
				+ order_price + ", order_quantity=" + order_quantity + ", order_amount=" + order_amount + "]";
	}
	
	
}
