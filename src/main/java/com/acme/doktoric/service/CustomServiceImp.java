package com.acme.doktoric.service;

import java.awt.print.Book;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.acme.doktoric.Loggable;
import com.acme.doktoric.dao.EmployeeRepository;
import com.acme.doktoric.dao.ProjectRepository;
import com.acme.doktoric.dao.TeamRepository;
import com.acme.doktoric.domain.Project;
import com.acme.doktoric.domain.Team;
import com.acme.doktoric.domain.emp.Employee;
import com.acme.doktoric.domain.emp.Manager;

@Service
@Qualifier("customService")
public class CustomServiceImp implements CustomService {

	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	// EMPLOYEE
	public void insertEmployee(Employee employee) {
		employeeRepository.insert(employee);
	}

	@Loggable
	public void persistEmployee(Employee employee) {
		employeeRepository.persitEmployee(employee);
	}
	
	@Loggable
	public void persistEmployees(Employee... employees) {
		for (Employee employee : employees) {
			employeeRepository.persitEmployee(employee);
		}
		
		
	}

	public void insertEmployeeWithRandomAge(Employee employee) {
		employeeRepository.insertPersonWithRandomAge(employee);
	}

	public void dropEmployeeCollection() {
		employeeRepository.dropEmployeeCollection();
	}

	public void createEmployeeCollection() {
		employeeRepository.createEmployeeCollection();
	}

	public Collection<Employee> getAllEmployees() {
		return employeeRepository.getAll();
	}

	public void insertPersonWithRandomAge(Employee person) {
		employeeRepository.insertPersonWithRandomAge(person);
	}

	public List<Employee> findWhoseAgeIsGreaterThan(int age) {
		return employeeRepository.findWhoseAgeIsGreaterThan(age);
	}

	@Loggable
	public List<Employee> findWhoseAgeIsLessThan(int age) {
		return employeeRepository.findWhoseAgeIsGreaterThan(age);
	}

	public void deleteEmployeesWithAge(int age) {
		employeeRepository.deleteEmployeesWithAge(age);
	}

	@Loggable
	public Collection<Manager> findAllManagers() {
		return employeeRepository.findAllManagers();
	}

	// TEAM

	public void dropTeamCollection() {
		teamRepository.dropTeamCollection();
	}

	public void createTeamCollection() {
		teamRepository.createTeamCollection();
	}

	public void persist(Team team) {
		teamRepository.persist(team);
	}

	@Loggable
	public Collection<Team> getAllTeams() {
		return teamRepository.getAll();
	}

	public void delete(Team team) {
		teamRepository.delete(team);
	}

	public void insert(Team team) {
		teamRepository.insert(team);
	}

	@Loggable
	public void insertWithWithGivenEmployees(Team team, Manager manager,
			Employee... employees) {
		teamRepository.insertWithWithGivenEmployees(team, manager, employees);
	}
	
	@Loggable
	public List<Team> findTeamWhereManagerIs(Manager manager) {
		return teamRepository.findTeamWhereManagerIs(manager);
	}

	// PROJECT
	public void dropProjectCollection() {
		projectRepository.dropProjectCollection();
	}

	public void createProjectCollection() {
		projectRepository.createProjectCollection();
	}

	public void persistProject(Project project) {
		projectRepository.persist(project);
	}

	public Collection<Project> getAllPerson() {
		return projectRepository.getAll();
	}

	public void delete(Project project) {

		projectRepository.delete(project);
	}

	@Loggable
	public void insertProjectWithTeam(Project project, Team... teams) {
		projectRepository.insertProjectWithTeam(project, teams);
	}
	
	//OTHERS
	@Loggable
	public void dropAllCollections() {
		dropEmployeeCollection();
		dropProjectCollection();
		dropTeamCollection();
	
	}
	
	@Loggable
	public void createAllCollections() {
		createEmployeeCollection();
		createProjectCollection();
		createTeamCollection();
	
	}

}
