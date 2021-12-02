package com.projectdemo.pos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

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
	
	public Employees() {
		
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", employee_id=" + employee_id + ", employee_name=" + employee_name + "]";
	}
	
	
	
	
	
	
	
}
