package com.projectdemo.pos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Items {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="item_id")
	private String item_id;
	
	@Column(name="item_description")
	private String item_description;
	
	@Column(name="item_price")
	private double item_price;
	
	@Column(name="item_tag")
	private String item_tag;
	
	public Items() {
		
	}
	
	public Items(String item_id, String item_description, double item_price, String item_tag) {
		this.item_id = item_id;
		this.item_description = item_description;
		this.item_price = item_price;
		this.item_tag = item_tag;
	}
	
	public Items(String item_id, String item_description, double item_price) {
		this.item_id = item_id;
		this.item_description = item_description;
		this.item_price = item_price;
		this.item_tag = null;
		
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getItem_description() {
		return item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}

	public double getItem_price() {
		return item_price;
	}

	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}

	public String getItem_tag() {
		return item_tag;
	}

	public void setItem_tag(String item_tag) {
		this.item_tag = item_tag;
	}
	
	
	
	
}
