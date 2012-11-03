package com.acme.doktoric.dao;

import java.awt.print.Book;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.acme.doktoric.domain.emp.Employee;
import com.acme.doktoric.domain.emp.Manager;

@Repository
public class EmployeeRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public Collection<Employee> getAll() {
		System.out.println("\ngetting all persons");
		return mongoTemplate.findAll(Employee.class);
	}

	public void insert(Employee person) {
		System.out.println("\ninserting: " + person);
		mongoTemplate.insert(person);
	}
	
	public void persitEmployee(Employee person) {
		mongoTemplate.save(person);
	}

	public void insertPersonWithRandomAge(Employee person) {
		double age = Math.ceil(Math.random() * 100);
		person.setAge((int) age);
		System.out.println("inserting person: " + person);
		mongoTemplate.insert(person);
	}

	public void createEmployeeCollection() {
		System.out.println("\ncreating collection: " + Employee.class);
		if (!mongoTemplate.collectionExists(Employee.class)) {
			mongoTemplate.createCollection(Employee.class);
		}
	}

	public void dropEmployeeCollection() {
		System.out.println("\ndropping collection: " + Employee.class);
		if (mongoTemplate.collectionExists(Employee.class)) {
			mongoTemplate.dropCollection(Employee.class);
		}
	}

	public List<Employee> findWhoseAgeIsGreaterThan(int age) {
		System.out.println("\nfinding those ppl whose age is greater than "
				+ age + ": ");
		Query query = new Query(Criteria.where("age").gt(age));
		return mongoTemplate.find(query, Employee.class);
	}

	public List<Employee> findWhoseAgeIsLessThan(int age) {
		System.out.println("\nfinding those ppl whose age is less than " + age
				+ ": ");
		Query query = new Query(Criteria.where("age").lt(age));
		return mongoTemplate.find(query, Employee.class);
	}

	public void deleteEmployeesWithAge(int age) {
		System.out.println("\ndelete persons with age: " + age);
		Query query = new Query(Criteria.where("age").is(age));
		mongoTemplate.remove(query, Employee.class);
	}

	public Collection<Manager> findAllManagers() {
		System.out.println("\nfinding all the managers");
		Query query = new Query(Criteria.where("_class").is(
				Manager.class.getCanonicalName()));
		return mongoTemplate.find(query, Manager.class);
	}

	

}
