package com.qb.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qb.entity.Leaves;
import com.qb.repo.LeavesRepo;

public class LeavesService {

	public ResponseEntity<String> saveLeavesData(Leaves data, LeavesRepo repo) {

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

}
