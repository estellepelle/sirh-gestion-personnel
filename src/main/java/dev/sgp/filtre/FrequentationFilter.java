package dev.sgp.filtre;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.VisiteStatistiques;
import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.VisiteWebService;
import dev.sgp.util.Constantes;

public class FrequentationFilter implements Filter{
	
	private FilterConfig config = null;
	
	// récupération du service
	private VisiteWebService visiteService = Constantes.VISITE_SERVICE;
	
	private int id=0;


	
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		config.getServletContext().log("FrequentationFilter initialized");
		
	}
	

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		long before = System.currentTimeMillis();
		String path = ((HttpServletRequest) req).getRequestURI();
		chain.doFilter(req, resp);
		long after = System.currentTimeMillis();
		long time = (after - before);
		boolean ok = true;
		
		config.getServletContext().log(path + " : " + time );
		
		VisiteWeb visite = new VisiteWeb(id++, path, time );
		
		visiteService.sauvegarderVisite(visite); 
		
		if(visiteService.listerStatVisites() == null) {
			visiteService.sauvegarderStatVisite(new VisiteStatistiques(path, 0, time, time, time));
		}
		
		for(int i=0; i<visiteService.listerStatVisites().size(); i++) {
			
			if(path.equals(visiteService.listerStatVisites().get(i).getChemin())) {
				
				ok = false;
				
				visiteService.listerStatVisites().get(i).incrementNbVisites();
				
				if(time < visiteService.listerStatVisites().get(i).getMinExecution() ) {
					
					visiteService.listerStatVisites().get(i).setMinExecution(time);
				}
				
				if(time > visiteService.listerStatVisites().get(i).getMaxExecution()) {
					
					visiteService.listerStatVisites().get(i).setMaxExecution(time);
					
				}
			}
		}
		
		if(ok) {
			visiteService.sauvegarderStatVisite(new VisiteStatistiques(path, 0, time, time, time));
		}
		
 	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	

}
