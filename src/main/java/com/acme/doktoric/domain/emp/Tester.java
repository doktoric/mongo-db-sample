package com.acme.doktoric.domain.emp;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="employee")
public class Tester extends Employee{

	
	public Tester(String name, int age) {
		emptype=EmpType.TESTER;
		this.name = name;
		this.age = age;
		
	}
	
	public Tester(String name) {
		emptype=EmpType.TESTER;
		this.name = name;
		this.age = 27;
		
	}
	
	public Tester() {
		emptype=EmpType.TESTER;
		this.name = "Test Elod";
		this.age = 27;
		
	}
	
	
	
	
	
}
