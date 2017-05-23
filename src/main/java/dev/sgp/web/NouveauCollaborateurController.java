package dev.sgp.web;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class NouveauCollaborateurController  extends HttpServlet {
	
	// récupération du service
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/collab/nouveauCollaborateur.jsp").forward(req, resp);

		
	} 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<Boolean, List<String>> validationParams = validerParametres(req, "nom","prenom", "dateNaissance", "adresse", "numSec");
		
		resp.setCharacterEncoding("utf-8");
		
		
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		
		String dateInterNaissance = req.getParameter("dateNaissance");
	
		String adresse = req.getParameter("adresse");
		String numSecParam = req.getParameter("numSec");
		
		
		
		if (validationParams.get(false) != null  || numSecParam.length() != 15 ) {
			resp.setStatus(400);
			
			resp.getWriter().write("Les paramètres suivants sont incorrects : " + validationParams.get(false).stream().collect(joining(",")));
		} else {
			
			LocalDate dateNaissance = LocalDate.parse(dateInterNaissance);
			
			String matricule = UUID.randomUUID().toString();
			
			String emailPro = prenom +  nom +"@societe.com";
			String photo = "img.png";
			
			ZonedDateTime dateHeureCreation = ZonedDateTime.now();

			resp.setStatus(201);
			
			Collaborateur collab = new Collaborateur(matricule, nom, prenom, dateNaissance, adresse, numSecParam, emailPro, photo, dateHeureCreation, true);
			
			collabService.sauvegarderCollaborateur(collab);
			
			
			
			
			resp.sendRedirect(req.getContextPath()+ "/collaborateurs/lister");
			
			
			
		}
		
	}
	


	private Map<Boolean, List<String>> validerParametres(HttpServletRequest req, String... params) {
		return Stream.of(params).collect(
				groupingBy(
						param -> req.getParameter(param) != null && !"".equals(req.getParameter(param)
				)));
	}

}
