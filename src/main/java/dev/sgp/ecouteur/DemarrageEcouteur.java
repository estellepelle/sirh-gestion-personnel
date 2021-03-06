package dev.sgp.ecouteur;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

@WebListener
public class DemarrageEcouteur implements ServletContextListener {
	

	@Inject private CollaborateurService collabService;
	@Inject private DepartementService depService;
	@Override
	public void contextInitialized(ServletContextEvent sce) {

		ZonedDateTime dateHeureCreation = ZonedDateTime.now();

		Stream.of(new Departement(1, "Comptabilité"), new Departement(2, "Ressources Humaines"),
				new Departement(3, "Informatique"), new Departement(4, "Administratif"))
				.forEach(dep -> depService.sauvegarderDepartement(dep));

		Stream.of(
				new Collaborateur("1", "ee", "ss", LocalDate.parse("1993-06-25"), "14", "121212121212121",
						"ee.ss@societe.com", "img.png", dateHeureCreation, true, depService.listerDepartements().get(0),
						"cic", "rc123", "RDV"),
				new Collaborateur("2", "est", "rr", LocalDate.parse("1993-06-25"), "14", "121212121212121",
						"ee.ss@societe.com", "img.png", dateHeureCreation, true, depService.listerDepartements().get(3),
						"cic", "4021GD", "CPD"),
				new Collaborateur("3", "pmp", "cdr", LocalDate.parse("1993-06-25"), "14", "121212121212121",
						"ee.ss@societe.com", "img.png", dateHeureCreation, true, depService.listerDepartements().get(1),
						"credit mutuel", "215DS", "POMP"),
				new Collaborateur("4", "sar", "vif", LocalDate.parse("1993-06-25"), "14", "121212121212121",
						"ee.ss@societe.com", "img.png", dateHeureCreation, true, depService.listerDepartements().get(2),
						"credit agricole", "mp456", "RDV"),
				new Collaborateur("5", "pop", "youpi", LocalDate.parse("1993-06-25"), "14", "121212121212121",
						"ee.ss@societe.com", "img.png", dateHeureCreation, true, depService.listerDepartements().get(0),
						"credit agricole", "fgt1235", "DPMP")

		).forEach(collab -> collabService.sauvegarderCollaborateur(collab));

	}
	
		
	
		
		
	

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
