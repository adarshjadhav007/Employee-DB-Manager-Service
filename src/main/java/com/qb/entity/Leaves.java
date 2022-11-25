package com.qb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Leaves {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int emp_id;
	
	private int no_of_days;
	
	private String from_date;
	
	private String to_date;
	
	private String stauts;	
	
}
