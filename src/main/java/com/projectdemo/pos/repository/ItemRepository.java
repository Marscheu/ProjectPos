package com.projectdemo.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectdemo.pos.entity.Items;

public interface ItemRepository extends JpaRepository<Items,Integer>{

}
