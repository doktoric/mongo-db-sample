package com.acme.doktoric.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.acme.doktoric.Loggable;
import com.acme.doktoric.domain.Project;
import com.acme.doktoric.domain.Team;
import com.acme.doktoric.domain.emp.Employee;
import com.acme.doktoric.domain.emp.Manager;

@Service
public interface CustomService {

	// EMPLOYEE
	
	public void insertEmployee(Employee employee);

	public void persistEmployee(Employee employee);

	public void persistEmployees(Employee... employees);

	public void insertEmployeeWithRandomAge(Employee employee);

	public void dropEmployeeCollection();

	public void createEmployeeCollection();

	public Collection<Employee> getAllEmployees();

	public void insertPersonWithRandomAge(Employee person);

	public List<Employee> findWhoseAgeIsGreaterThan(int age);

	public List<Employee> findWhoseAgeIsLessThan(int age);

	public void deleteEmployeesWithAge(int age);

	public Collection<Manager> findAllManagers();

	// TEAM
	public void dropTeamCollection();

	public void createTeamCollection();

	public void persist(Team team);

	public Collection<Team> getAllTeams();

	public void delete(Team team);

	public void insert(Team team);

	public void insertWithWithGivenEmployees(Team team, Manager manager,
			Employee... employees);

	public List<Team> findTeamWhereManagerIs(Manager manager);

	// PROJECT
	public void dropProjectCollection();

	public void createProjectCollection();

	public void persistProject(Project project);

	public Collection<Project> getAllPerson();

	public void delete(Project project);

	public void insertProjectWithTeam(Project project, Team... teams);

	// OTHERS
	public void dropAllCollections();

	public void createAllCollections();
}
