package com.acme.doktoric.domain.emp;

import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="employee")
public class Manager extends Employee{

	
	private EmpType emptype=EmpType.MANAGER;

	public EmpType getEmptype() {
		return emptype;
	}

	public void setEmptype(EmpType emptype) {
		this.emptype = emptype;
	}
	
	public Manager(String name, int age) {
		
		this.name = name;
		this.age = age;
		
	}
	
	public Manager(String name) {
		this.name = name;
		this.age = 40;
		
	}
	
	public Manager() {
		this.name = "Deb Ilona";
		this.age = 40;
		
	}
	
}
