package com.qb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qb.entity.Employee;
import com.qb.repo.AddressRepo;
import com.qb.repo.EmployeeRepo;



@RestController
public class EmployeeDBManagerController {
	
	@Autowired
	EmployeeRepo repo;
	
	@Autowired
	AddressRepo addressRepo;
	
	@PostMapping("/addemployee")
	public Employee saveEmployeeDetails(@RequestBody Employee data) {
		
		System.out.println(data);
		data.setCurrent_address(addressRepo.save(data.getCurrent_address()));
		data.setPermanent_address(addressRepo.save(data.getPermanent_address()));
		
		return repo.save(data);
	}
	
	@GetMapping("/getemployeedetails")
	public List<Employee> getAllEmployeeDetails(){
		
		return repo.findAll();
	}
	
	@GetMapping("/getemployeedetails/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable("id") int id){
		
		return repo.findById(id);
	}
	
}
