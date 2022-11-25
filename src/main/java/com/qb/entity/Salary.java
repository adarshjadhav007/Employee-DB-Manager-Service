package com.qb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Salary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int emp_id;
	
	private String month;
	
	private String year;
	
	private long basic_pay;
	
	private long bonus;
	
	private long hra;
	
	private long total;
	
}
