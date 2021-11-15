package com.projectdemo.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.projectdemo.pos.repository.EmployeeRepository;

@CrossOrigin
@RestController
public class EmployeesController {
	
	@Autowired
	EmployeeRepository empRepository;
	
	
}
