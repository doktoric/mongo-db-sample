package com.acme.doktoric.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.acme.doktoric.domain.Project;
import com.acme.doktoric.domain.Team;
import com.acme.doktoric.domain.emp.Employee;
import com.acme.doktoric.domain.emp.Manager;

@Repository
public class ProjectRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void dropProjectCollection() {
		// TODO Auto-generated method stub
		if (mongoTemplate.collectionExists(Project.class)) {
			mongoTemplate.dropCollection(Project.class);
		}
	}

	public void createProjectCollection() {
		// TODO Auto-generated method stub
		if (!mongoTemplate.collectionExists(Project.class)) {
			mongoTemplate.createCollection(Project.class);
		}
	}

	public void insertProjectWithTeam(Project project,Team... teams) {
		// TODO Auto-generated method stub
		for (Team team : teams) {
			project.addTeam(team);
		}
		mongoTemplate.insert(project);
	}
	
	
	public void persist(Project project) {
		// TODO Auto-generated method stub
		mongoTemplate.save(project);
	}

	public Collection<Project> getAll() {
		return mongoTemplate.findAll(Project.class);
	}

	public void delete(Project project) {

		mongoTemplate.remove(project);
	}

}
