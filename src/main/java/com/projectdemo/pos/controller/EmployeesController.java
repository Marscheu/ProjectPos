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
	
	
	public EmployeesController(Employees emp) {
		
	}
	
	public EmployeesController() {
		
	}
	
	@GetMapping("/employees")
	public List<Employees> getEmployeesList(){

		return empRepository.findAll();
		
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Employees> getSingleEmployee(@PathVariable int id) {
		return empRepository.findById(id);
	}
	
	@PostMapping("/employees/add")
	public void addSingleEmployee(@RequestBody Employees emp) {
		empRepository.save(emp);
		logger.info("New employee added!");
	}
	
	@DeleteMapping("/employees/remove/{id}")
	public void deleteSingleEmployee(@PathVariable int id) {
		
		empRepository.deleteById(id);
		logger.info("Employee ID " + id + " has been successfully deleted.");
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
			logger.info("Updated employee successfully");
			
		}catch(NullPointerException e) {
			logger.warn("Employee with ID " + id + " was not found.");
			
		}catch(NoSuchElementException e) {
			
			logger.warn("No Employee Found!");	
		}
	}
	
	
	
	
	
}
