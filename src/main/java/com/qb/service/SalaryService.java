package com.qb.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qb.entity.Salary;
import com.qb.repo.SalaryRepo;



public class SalaryService {

	public ResponseEntity<Salary> saveSalary(Salary data, SalaryRepo repo) {
		HttpHeaders responseHeaders = new HttpHeaders();
		
		try {
			data.setTotal(data.getBasic_pay()+data.getBonus()+data.getHra());
			repo.save(data);
			
			return new ResponseEntity("Data Saved Suceesfully",responseHeaders,HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity("Employee ID not present", responseHeaders, HttpStatus.BAD_REQUEST);
		}
		
	}

}
