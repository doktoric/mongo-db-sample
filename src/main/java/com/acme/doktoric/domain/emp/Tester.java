package com.acme.doktoric.domain.emp;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="employee")
public class Tester extends Employee{

	private EmpType emptype=EmpType.TESTER;

	public Tester(String name, int age) {
		
		this.name = name;
		this.age = age;
		
	}
	
	public Tester(String name) {
		this.name = name;
		this.age = 27;
		
	}
	
	public Tester() {
		this.name = "Test Elod";
		this.age = 27;
		
	}
	
	
	public EmpType getEmptype() {
		return emptype;
	}

	public void setEmptype(EmpType emptype) {
		this.emptype = emptype;
	}
	
	
	
}
