package com.acme.doktoric.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.acme.doktoric.domain.Team;
import com.acme.doktoric.domain.emp.Employee;
import com.acme.doktoric.domain.emp.Manager;

@Repository
public class TeamRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void dropTeamCollection() {
		// TODO Auto-generated method stub
		if (mongoTemplate.collectionExists(Team.class)) {
			mongoTemplate.dropCollection(Team.class);
		}
	}

	public void createTeamCollection() {
		// TODO Auto-generated method stub
		if (!mongoTemplate.collectionExists(Team.class)) {
			mongoTemplate.createCollection(Team.class);
		}
	}

	public void persist(Team team) {
		// TODO Auto-generated method stub
		mongoTemplate.save(team);
	}

	public Collection<Team> getAll() {
		return mongoTemplate.findAll(Team.class);
	}

	public void delete(Team team) {

		mongoTemplate.remove(team);
	}

	public void insert(Team team) {
		mongoTemplate.insert(team);
	}

	public void insertWithWithGivenEmployees(Team team, Manager manager,
			Employee... employees) {
		for (Employee emp : employees) {
			team.addEmployee(emp);
		}
		team.setManager(manager);

		mongoTemplate.insert(team);
	}

	public List<Team> findTeamWhereManagerIs(Manager manager) {
		Query query = new Query(Criteria.where("manager.$id").is(
				manager.getObjectId()));
		return mongoTemplate.find(query, Team.class);
	}

}
