package dev.sgp.rest;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;

@Path("/collaborateurs")
public class CollaborateurResource {
	

	@Inject private CollaborateurService collabService;
	
	public CollaborateurResource(){
		
	
		
		//@QueryParam("idDep") int idDep	
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Collaborateur> list(@QueryParam("departement") Integer idDep) {
		
		
		
		return collabService.listerCollaborateurs(idDep);
	}
	
	
	

	
	
}
