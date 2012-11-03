package com.acme.doktoric.domain.emp;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public abstract class Employee {

	@Id
	protected ObjectId objectId=ObjectId.get();
	protected String name;
	protected int age;
	protected EmpType emptype=EmpType.MANAGER;

	
	
	public EmpType getEmptype() {
		return emptype;
	}

	public void setEmptype(EmpType emptype) {
		this.emptype = emptype;
	}
	
	public ObjectId getObjectId() {
		return objectId;
	}
	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "name=" + name + ", age="
				+ age + ", emptype=" + emptype + "";
	}


	
	
	
	

}
