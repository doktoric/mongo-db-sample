package com.acme.doktoric;

import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.doktoric.domain.Project;
import com.acme.doktoric.domain.Team;
import com.acme.doktoric.domain.emp.Employee;
import com.acme.doktoric.domain.emp.Manager;
import com.acme.doktoric.domain.emp.Programmer;
import com.acme.doktoric.service.CustomService;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"META-INF/spring.xml");
		CustomService customService = context.getBean(CustomService.class);

		customService.dropEmployeeCollection();
		customService.dropProjectCollection();
		customService.dropTeamCollection();

		customService.createEmployeeCollection();
		customService.createProjectCollection();
		customService.createTeamCollection();

		Employee pBela = new Programmer("bela",20);
		Employee pOliver = new Programmer("oliver",21);
		Employee pGeza = new Programmer("geza",22);
		Employee pPeter = new Programmer("peter",23);
		Employee pGunter = new Programmer("gunter",24);
		Employee pRicsi = new Programmer("ricsi",25);
		Employee pLajos = new Programmer("lajos",26);
		Employee pKrisztian = new Programmer("krisztian",27);
		Employee pJanos = new Programmer("janos",28);
		Employee pMarci = new Programmer("marci",29);
		Employee pGergo = new Programmer("gergo",30);
		
		customService.persistEmployee(pBela);
		customService.persistEmployee(pGergo);
		customService.persistEmployee(pGeza);
		customService.persistEmployee(pGunter);
		customService.persistEmployee(pJanos);
		customService.persistEmployee(pKrisztian);
		customService.persistEmployee(pLajos);
		customService.persistEmployee(pMarci);
		customService.persistEmployee(pOliver);
		customService.persistEmployee(pPeter);
		customService.persistEmployee(pRicsi);
		
		Employee tZita = new Programmer("zita",20);
		Employee tGizi = new Programmer("gizi",21);
		Employee tLili = new Programmer("lili",22);
		Employee tMarta = new Programmer("marta",23);
		Employee tJutka = new Programmer("jutka",24);
		Employee tLujza = new Programmer("lujza",25);
		Employee tNiki = new Programmer("niki",26);
		Employee tMonika = new Programmer("monika",27);
		Employee tMarietta = new Programmer("marietta",28);
		Employee tLaura = new Programmer("laura",29);
		Employee tLolka = new Programmer("lolka",30);
		
		customService.persistEmployee(tGizi);
		customService.persistEmployee(tJutka);
		customService.persistEmployee(tLaura);
		customService.persistEmployee(tLili);
		customService.persistEmployee(tLolka);
		customService.persistEmployee(tLujza);
		customService.persistEmployee(tMarietta);
		customService.persistEmployee(tMarta);
		customService.persistEmployee(tMonika);
		customService.persistEmployee(tNiki);
		customService.persistEmployee(tZita);
		
		Manager mRobi=new Manager("robi");
		Manager mRita=new Manager("rita");
		
		customService.persistEmployee(mRobi);
		customService.persistEmployee(mRita);
		
		
		Team ubs1=new  Team("UBS1");
		Team ubs2=new  Team("UBS2");
		
		customService.insertWithWithGivenEmployees(ubs1, mRobi, pBela,pGergo,pGeza,pGunter,pJanos,pKrisztian,tGizi,tJutka,tLaura,tLili,tLolka,tLujza);
		customService.insertWithWithGivenEmployees(ubs2, mRita, pLajos,pMarci,pOliver,pPeter,pRicsi,tMarietta,tMarta,tMonika,tNiki,tZita);
		
		
		
		
		Project project=new Project("UBS");
		customService.insertProjectWithTeam(project, ubs1,ubs2);
		
		printCollection(customService.getAllTeams());
		
		
	}
	
	
	 private static void printCollection(Collection<Team> teams) {
	        for (Team team : teams)
	            System.out.println(team);
	    }
}
