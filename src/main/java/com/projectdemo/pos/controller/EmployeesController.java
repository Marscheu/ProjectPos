package com.projectdemo.pos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectdemo.pos.entity.Employees;
import com.projectdemo.pos.repository.EmployeeRepository;
import com.projectdemo.pos.service.EmployeeService;

@CrossOrigin
@RestController
public class EmployeesController {
	
	@Autowired
	EmployeeRepository empRepository;
	
	private static Logger logger = LoggerFactory.getLogger(EmployeesController.class);
	
	public EmployeesController(Employees emp) { }
	
	public EmployeesController() { }
	
	@GetMapping("/employees")
	public List<Employees> getEmployeesList(){
		
		try {
			return empRepository.findAll();
			
		}catch(Exception e) {
			logger.warn(e.getLocalizedMessage());
		}
		return null;
	
	}
	
	@GetMapping("/employees/{id}")
	public Employees getSingleEmployee(@PathVariable int id) {		
		
		try {
			Optional<Employees> employeeGetter = empRepository.findById(id);
			Employees singleEmployee = employeeGetter.get();
			return singleEmployee;
		}catch(NoSuchElementException e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
	@PostMapping("/employees/add")
	public void addSingleEmployee(@RequestBody Employees emp) {
		
		try {
			empRepository.save(emp);
			logger.info("HTTP POST: New employee added!");
		}catch(NoSuchElementException e) {
			logger.warn(e.getLocalizedMessage());
		}
		
	}
	
	@DeleteMapping("/employees/remove/{id}")
	public void deleteSingleEmployee(@PathVariable int id) {
		
		try {
			empRepository.deleteById(id);
			logger.info("HTTP DELETE: Employee ID " + id + " has been successfully deleted.");
		}catch(NoSuchElementException e) {
			logger.error(e.getLocalizedMessage());
		}
		
	}
	
	@PutMapping("/employees/edit/{id}")
	public void updateSingleEmployee(@PathVariable int id, @RequestBody Employees emp) {
		
		EmployeeService empService = new EmployeeService();
		Employees employee, employee2;
		
		try {
			Optional<Employees> optionalEmployee = empRepository.findById(id);
			employee = optionalEmployee.get();
			employee2 = empService.EmployeeUpdate(employee, emp);
			
			empRepository.save(employee2);
			logger.info("HTTP UPDATE: Updated employee successfully");
			
		}catch(NullPointerException e) {
			logger.warn("HTTP UPDATE: Employee with ID " + id + " was not found.");
			
		}catch(NoSuchElementException e) {
			logger.warn("HTTP UPDATE: No Employee Found!");
			
		}
	}	
}
