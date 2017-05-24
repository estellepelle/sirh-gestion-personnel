package dev.sgp.filtre;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteWebService;



@WebFilter(urlPatterns = { "/*" },description = "Request statistic filter")
public class FrequentationFilter implements Filter{
	
	
	
	// récupération du service
	@Inject private VisiteWebService visiteService ;
	


	
	@Override
	public void init(FilterConfig config) throws ServletException {
	
	}
	

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		long before = System.currentTimeMillis();
		String path = ((HttpServletRequest) req).getRequestURI();
		chain.doFilter(req, resp);
		long after = System.currentTimeMillis();
		long time = (after - before);
		
		
		visiteService.sauvegarderVisite(new VisiteWeb( path, time )); 
	
		
 	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	

}
