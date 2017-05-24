package dev.sgp.service;


import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;

@ApplicationScoped
public class CollaborateurService {
	
	List<Collaborateur> listeCollaborateurs = new ArrayList<>();
	
	ZonedDateTime dateHeureCreation = ZonedDateTime.now();
	TypeCollabEvt type;
	
	@Inject Event<CollabEvt> collabEvt;
	
	public List<Collaborateur> listerCollaborateurs() {
		return listeCollaborateurs;
	}

	public void sauvegarderCollaborateur(Collaborateur collab) {
		listeCollaborateurs.add(collab);
		
		
	
		
		CollabEvt nouveauCollabEvt =  new CollabEvt(collab.getMatricule(), type.CREATION_COLLAB, dateHeureCreation);
		collabEvt.fire(nouveauCollabEvt);
	}

}
