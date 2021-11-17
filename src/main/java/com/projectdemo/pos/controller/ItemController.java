package com.projectdemo.pos.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.projectdemo.pos.entity.Employees;
import com.projectdemo.pos.entity.Items;
import com.projectdemo.pos.repository.ItemRepository;

@CrossOrigin
@RestController
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;
	
	private static Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	
	public ItemController() {
		
	}
	
	public ItemController(Employees emp) {
		
	}
	
	@GetMapping("/items/all")
	public List<Items> getAllItems(){
		
		logger.info("All items displayed successfully!");
		return itemRepository.findAll();
		
	}
	
	@GetMapping("/items/{id}")
	public Items getSingleItem(@PathVariable int id) {
		
		Items item;
		
		try {
			
			Optional<Items> optionalItem = itemRepository.findById(id);
			item = optionalItem.get();
			
			logger.info("Successfully found a item");
			return item;
			
			
		}catch(NullPointerException e) {
			logger.warn("No item was found with ID " + id + " .");
		}catch(NoSuchElementException e) {
			logger.warn("NO ELEMENT FOUND");
			
		}
		return null;
		
		
	}
	
	
	
	

}