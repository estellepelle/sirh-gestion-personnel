package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.VisiteStatistiques;
import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteWebService;
import dev.sgp.util.Constantes;

public class ListerVisiteController extends HttpServlet {


	// récupération du service
	private VisiteWebService visiteService = Constantes.VISITE_SERVICE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	// utilisation du service
			List<VisiteStatistiques> visites = visiteService.construireStatistiques();
			
			req.setAttribute("visites", visites);
			
			req.getRequestDispatcher("/WEB-INF/views/collab/listerVisites.jsp")
			.forward(req, resp);
	}
}
