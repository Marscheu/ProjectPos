package com.projectdemo.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectdemo.pos.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {

}
