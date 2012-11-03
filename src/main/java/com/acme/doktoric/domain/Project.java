package com.acme.doktoric.domain;


import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Project {

	@Id
	private ObjectId objectId=ObjectId.get();
	private String name;
	@DBRef
	private List<Team> teams= new ArrayList<Team>();
	
	
	
	
	
	public Project(String name) {
		
		this.name = name;
	}
	public Project() {
		
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(objectId+"\n");
		sb.append(name+"\n");
		for (Team team : teams) {
			sb.append(team);
			
		}
		
		return sb.toString() ;
		
		
	}
	public void addTeam(Team team) {
		// TODO Auto-generated method stub
		teams.add(team);
	}
	
	
	
}
