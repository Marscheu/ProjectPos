package com.projectdemo.pos.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="order_id")
	private String order_id;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="order_item")
	private List<Items> order_item = new ArrayList<>();
	
	@Column(name="order_price")
	private double order_price;
	
	@Column(name="order_quantity")
	private int order_quantity;
	
	@Column(name="order_amount")
	private double order_amount;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="order_cashier")
	private Employees order_cashier;

}
