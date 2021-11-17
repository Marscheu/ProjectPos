package com.projectdemo.pos.service;

import com.projectdemo.pos.entity.Employees;

public class EmployeeService {
	
	public EmployeeService() {
		
	}
	
	public Employees EmployeeUpdate(Employees updatedEmployee, Employees oldEmployee) {
		
		updatedEmployee.setEmployee_id(oldEmployee.getEmployee_id());
		updatedEmployee.setEmployee_name(oldEmployee.getEmployee_name());
		
		System.out.println("This is the new employee " + updatedEmployee);
		return updatedEmployee;
	}
	
	
}
