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

	private Employee pBela = new Programmer("bela", 20);
	private Employee pOliver = new Programmer("oliver", 21);
	private Employee pGeza = new Programmer("geza", 22);
	private Employee pPeter = new Programmer("peter", 23);
	private Employee pGunter = new Programmer("gunter", 24);
	private Employee pRicsi = new Programmer("ricsi", 25);
	private Employee pLajos = new Programmer("lajos", 26);
	private Employee pKrisztian = new Programmer("krisztian", 27);
	private Employee pJanos = new Programmer("janos", 28);
	private Employee pMarci = new Programmer("marci", 29);
	private Employee pGergo = new Programmer("gergo", 30);
	private Employee tZita = new Programmer("zita", 20);
	private Employee tGizi = new Programmer("gizi", 21);
	private Employee tLili = new Programmer("lili", 22);
	private Employee tMarta = new Programmer("marta", 23);
	private Employee tJutka = new Programmer("jutka", 24);
	private Employee tLujza = new Programmer("lujza", 25);
	private Employee tNiki = new Programmer("niki", 26);
	private Employee tMonika = new Programmer("monika", 27);
	private Employee tMarietta = new Programmer("marietta", 28);
	private Employee tLaura = new Programmer("laura", 29);
	private Employee tLolka = new Programmer("lolka", 30);
	private Manager mRobi = new Manager("robi");
	private Manager mRita = new Manager("rita");
	private Team ubs1 = new Team("UBS1");
	private Team ubs2 = new Team("UBS2");
	private Project project = new Project("UBS");

	public App() {

	}

	public void run() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"META-INF/spring.xml");
		CustomService customService = context.getBean(CustomService.class);

		customService.dropAllCollections();
		customService.createAllCollections();

		customService.persistEmployees(pBela, pGergo, pGeza, pGunter, pJanos,
				pKrisztian, pLajos, pMarci, pOliver, pPeter, pRicsi, tGizi,
				tJutka, tLaura, tLili, tLolka, tLujza, tMarietta, tMarta,
				tMonika, tNiki, tZita, mRobi, mRita);

		customService.insertWithWithGivenEmployees(ubs1, mRobi, pBela, pGergo,
				pGeza, pGunter, pJanos, pKrisztian, tGizi, tJutka, tLaura,
				tLili, tLolka, tLujza);
		customService.insertWithWithGivenEmployees(ubs2, mRita, pLajos, pMarci,
				pOliver, pPeter, pRicsi, tMarietta, tMarta, tMonika, tNiki,
				tZita);

		customService.insertProjectWithTeam(project, ubs1, ubs2);

		System.out.println("\nALL TEAM:");
		printTeamsCollection(customService.getAllTeams());
		System.out.println("\nAGE < 27:");
		printEmployeeCollection(customService.findWhoseAgeIsLessThan(27));
		System.out.println("\nMANAGERS:");
		printEmployeeCollection(customService.findAllManagers());
		System.out.println("\nFIND ROBI MANAGERS:");
		printTeamsCollection(customService.findTeamWhereManagerIs(mRobi));
		
	}

	public static void main(String[] args) {
		App app = new App();
		app.run();
	}

	protected void printEmployeeCollection(Collection<? extends Employee> employees) {
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		
	}
	
	protected void printTeamsCollection(Collection<Team> teams) {
		for (Team team : teams) {
		
			System.out.println(team);
		}
	}
}
