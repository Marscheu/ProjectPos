package com.projectdemo.pos.controller;

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
import com.projectdemo.pos.entity.Items;
import com.projectdemo.pos.repository.ItemRepository;
import com.projectdemo.pos.service.ItemService;

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
		return itemRepository.findAll();
		
	}
	
	@GetMapping("/items/{id}")
	public Items getSingleItem(@PathVariable int id) {
		
		Items item;
		
		try {
			
			Optional<Items> optionalItem = itemRepository.findById(id);
			item = optionalItem.get();
			
			logger.info("HTTP POST: Successfully found a item");
			return item;
			
			
		}catch(NullPointerException e) {
			logger.warn("HTTP POST: No item was found with ID " + id + " .");
		}catch(NoSuchElementException e) {
			logger.warn("HTTP POST: No items found.");
			
		}
		return null;
		
		
	}
	
	@PostMapping("/items/add")
	public void addSingleItem(@RequestBody Items item) {
		
		itemRepository.save(item);
		logger.info("HTTP POST: Item successfully added!");
	}
	
	@PutMapping("/items/edit/{id}")
	public void updateSingleItem(@PathVariable int id, @RequestBody Items newItem) {
		
		/**
		 * 1. Initialize itemService and the item object.
		 * 2. Get the old Item object using Optional<TYPE> and the .get() and put it inside the item object
		 * 		you just instantiated.
		 * 3. In the itemService, run the method that updates the old item by passing new Item and old Item.
		 * 4. Put the said itemService method inside the itemRepository.save().
		 * 5. OPTIONAL: Put it inside a try-catch.
		 */
		
		
		ItemService itemService = new ItemService();
		Items oldItem;
		
		Optional<Items> oldItemGetter = itemRepository.findById(id);
		oldItem = oldItemGetter.get();
		
		itemRepository.save(itemService.updateSingleItem(newItem,oldItem));
		logger.info("HTTP PUT: Updated the item successfully!");
		
	}
	
	@DeleteMapping("/items/delete/{id}")
	public void deleteSingleItem(@PathVariable int id) {
		
		itemRepository.deleteById(id);	
		logger.info("HTTP DELETE: Deleted an Item Successfully.");
	}
	
}