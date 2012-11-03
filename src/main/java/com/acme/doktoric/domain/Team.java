package com.acme.doktoric.domain;

import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.acme.doktoric.domain.emp.Employee;
import com.acme.doktoric.domain.emp.Manager;
import com.acme.doktoric.domain.emp.Programmer;
import com.acme.doktoric.domain.emp.Tester;

@Document
public class Team {

	@Id
	private ObjectId objectId=ObjectId.get();
	private String name;

	@DBRef
	Set<Employee> employees = new HashSet<Employee>();
	@DBRef
	Manager manager;
	
	
	
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	
	public Team() {
		
	}
	
	public Team(String name) {
		this.name=name;
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
	
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		employees.add(emp);
	}

	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		
		sb.append("name:     "+name+"\n");
		sb.append("manager:  "+manager+"\n");
		sb.append("team:  "+"\n");
		for (Employee emp : employees) {
			sb.append("\t  "+emp+"\n");
		}
		
		
		return sb.toString();
	}
	
	
	
	
	
	
}
