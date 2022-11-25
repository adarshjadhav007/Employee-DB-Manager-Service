package com.qb.controller;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qb.entity.Leaves;
import com.qb.repo.LeavesRepo;

@RestController
public class LeavesController {

	@Autowired
	LeavesRepo repo;
	
	@PostMapping("saveLeavedetails")
	public ResponseEntity<String> saveLeavesData(@RequestBody Leaves data) throws ParseException {
		HttpHeaders responseHeaders = new HttpHeaders();
		try {
			SimpleDateFormat obj = new SimpleDateFormat("dd-mm-yyyy");  
			
			Date date1 = obj.parse(data.getFrom_date());   
	        Date date2 = obj.parse(data.getTo_date()); 
	        long time_difference = date2.getTime() - date1.getTime();  
	        long days_difference = (time_difference / (1000*60*60*24)) % 365; 
	        
	        	
	        
			data.setNo_of_days((int)days_difference);
			Leaves leaves= null;
		//	HttpHeaders responseHeaders = new HttpHeaders();
			if(days_difference<1) {
				return new ResponseEntity<>("Incorrect 'From Date'", responseHeaders, HttpStatus.BAD_REQUEST);
			}
			leaves = repo.save(data);
			return new ResponseEntity<>("Data save successfully", responseHeaders, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>("Employee ID not present", responseHeaders, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("leavesalldetails")
	public List<Leaves> getAllLeavesDetails(){
		
		return repo.findAll();
	}
	
	
	
	
}
