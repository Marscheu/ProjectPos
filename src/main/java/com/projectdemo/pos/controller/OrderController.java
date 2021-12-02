package com.projectdemo.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectdemo.pos.entity.Employees;
import com.projectdemo.pos.entity.Orders;
import com.projectdemo.pos.repository.OrdersRepository;

@CrossOrigin
@RestController
public class OrderController {
	
	@Autowired
	OrdersRepository orderRepository;
	
	
	public OrderController(Employees emp) {
		
	}
	
	public OrderController() {
		
	}
	
	@GetMapping("/orders/all")
	public List<Orders> getAllOrder(){
		
		return orderRepository.findAll();
	}
	
	
	
	
}
