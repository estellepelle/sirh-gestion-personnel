package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.VisiteStatistiques;
import dev.sgp.service.VisiteWebService;


@WebServlet("/visite/lister")
public class ListerVisiteController extends HttpServlet {

	// récupération du service
	@Inject
	private VisiteWebService visiteService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// utilisation du service
		List<VisiteStatistiques> visites = visiteService.construireStatistiques();

		req.setAttribute("visites", visites);

		req.getRequestDispatcher("/WEB-INF/views/collab/listerVisites.jsp").forward(req, resp);
	}
}
