package com.projectdemo.pos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employees {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="employee_id")
	private String employee_id;
	
	@Column(name="employee_name")
	private String employee_name;
	
	public Employees(String employee_id, String employee_name){
		this.employee_id = employee_id;
		this.employee_name = employee_name;
	}
	
	
	
	
}
