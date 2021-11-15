package com.projectdemo.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectdemo.pos.entity.Employees;

public interface EmployeeRepository extends JpaRepository<Employees,Integer>{

}
