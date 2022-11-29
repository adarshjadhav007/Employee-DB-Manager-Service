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
import com.qb.service.LeavesService;

@RestController
public class LeavesController {

	@Autowired
	LeavesRepo repo;
	
	@PostMapping("saveLeavedetails")
	public ResponseEntity<String> saveLeavesData(@RequestBody Leaves data) throws ParseException {
		
		LeavesService service = new LeavesService();
		
		return service.saveLeavesData(data,repo);
		
		
	}
	
	@GetMapping("leavesalldetails")
	public List<Leaves> getAllLeavesDetails(){
		
		return repo.findAll();
	}
	
	
	
	
}
