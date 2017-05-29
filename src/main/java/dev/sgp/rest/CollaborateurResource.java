package dev.sgp.rest;

import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;

@Path("/collaborateurs")
public class CollaborateurResource {

	@Inject
	private CollaborateurService collabService;
	@Inject
	Event<CollabEvt> collabEvent;

	public CollaborateurResource() {

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Collaborateur> list(@QueryParam("departement") Integer idDep) {

		return collabService.listerCollaborateurs(idDep);
	}

	@GET
	@Path("/{matricule}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collaborateur findByMatricule(@PathParam("matricule") String matricule) {

		return collabService.leCollaborateur(matricule);
	}

	@GET
	@Path("/{matricule}/banque")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> findByMatriculeBanque(@PathParam("matricule") String matricule) {

		return collabService.afficheBanque(matricule);

	}

	@PUT
	@Path("/{matricule}")
	@Produces(MediaType.APPLICATION_JSON)
	public void modifCollab(@PathParam("matricule") String matricule, Collaborateur collab) {

		collabService.modifCollaborateur(matricule, collab);
	}

	@PUT
	@Path("/{matricule}/banque")
	@Produces(MediaType.APPLICATION_JSON)
	public void modifBanque(@PathParam("matricule") String matricule, Collaborateur collab) {

		collabService.modifDonneBanque(matricule, collab);

	}

}
