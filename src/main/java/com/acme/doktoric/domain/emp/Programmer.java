package com.acme.doktoric.domain.emp;

import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="employee")
public class Programmer extends Employee{

	

	public Programmer(String name, int age) {
		emptype=EmpType.PROGRAMMER;
		this.name = name;
		this.age = age;
		
	}
	
	public Programmer(String name) {
		emptype=EmpType.PROGRAMMER;
		this.name = name;
		this.age = 23;
		
	}
	
	public Programmer() {
		emptype=EmpType.PROGRAMMER;
		this.name = "Koc Katalin";
		this.age = 23;
		
	}
	
	
	
	
	
	
}
