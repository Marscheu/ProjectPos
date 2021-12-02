package com.projectdemo.pos.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.projectdemo.pos.controller.ItemController;
import com.projectdemo.pos.entity.Items;

public class ItemService {
	
	private static Logger logger = LoggerFactory.getLogger(ItemService.class);
	
	
	public Items updateSingleItem(Items updatedItem, Items oldItem) {
		
		oldItem.setItem_id(updatedItem.getItem_id());
		oldItem.setItem_description(updatedItem.getItem_description());
		oldItem.setItem_price(updatedItem.getItem_price());
		oldItem.setItem_tag(updatedItem.getItem_tag());
		
		logger.info("Update Done!");
		
		return oldItem;
	}

}
