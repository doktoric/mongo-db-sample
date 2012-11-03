package com.acme.doktoric.domain.emp;

import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="employee")
public class Manager extends Employee{

	
	
	
	public Manager(String name, int age) {
		emptype=EmpType.MANAGER;
		this.name = name;
		this.age = age;
		
	}
	
	public Manager(String name) {
		emptype=EmpType.MANAGER;
		this.name = name;
		this.age = 40;
		
	}
	
	public Manager() {
		emptype=EmpType.MANAGER;
		this.name = "Deb Ilona";
		this.age = 40;
		
	}
	
}
