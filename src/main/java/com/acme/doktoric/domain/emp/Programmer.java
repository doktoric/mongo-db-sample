package com.acme.doktoric.domain.emp;

import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="employee")
public class Programmer extends Employee{

	private EmpType emptype=EmpType.PROGRAMMER;

	public Programmer(String name, int age) {
		
		this.name = name;
		this.age = age;
		
	}
	
	public Programmer(String name) {
		this.name = name;
		this.age = 23;
		
	}
	
	public Programmer() {
		this.name = "Koc Katalin";
		this.age = 23;
		
	}
	
	
	
	public EmpType getEmptype() {
		return emptype;
	}

	public void setEmptype(EmpType emptype) {
		this.emptype = emptype;
	}
	
	
	
}
