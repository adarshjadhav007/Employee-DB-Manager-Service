package com.qb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qb.entity.Salary;
import com.qb.repo.SalaryRepo;
import com.qb.service.SalaryService;

@RestController
public class SalaryController {
	
	@Autowired
	SalaryRepo repo;
	
	@PostMapping("/addsalary")
	public ResponseEntity<Salary> saveSalaryDetails(@RequestBody Salary data) {
		SalaryService service = new SalaryService();
		
		return service.saveSalary(data, repo);
	}
	
	@GetMapping("/getsalarydetails")
	public List<Salary> getSalaryDetails(){
		
		return repo.findAll();
	}

	
}
