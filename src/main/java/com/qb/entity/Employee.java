package com.qb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String first_name;
	
	private String last_name;
	
	private int age;
	
	private String gender;
	
	private String contact_number;
	
	private String emg_contact_number;
	
	@OneToOne
	private Address current_address;
	
	@OneToOne
	private Address permanent_address;
}
