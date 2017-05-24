package dev.sgp.service;


import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;


@Stateless
public class CollaborateurService {
	
	@PersistenceContext(unitName="sgp-pu") private EntityManager em;
	
	
	
	ZonedDateTime dateHeureCreation = ZonedDateTime.now();
	TypeCollabEvt type;
	
	@Inject Event<CollabEvt> collabEvt;
	
	public List<Collaborateur> listerCollaborateurs() {
		
		List<Collaborateur> listeCollaborateur = new ArrayList<>();
		
		
		TypedQuery<Collaborateur> query = em.createQuery("SELECT c FROM Collaborateur c",Collaborateur.class);
		
		listeCollaborateur = query.getResultList();
	

		
		return listeCollaborateur;
	}

	
	public void sauvegarderCollaborateur(Collaborateur collab) {
		
	
		em.persist(collab);

		
		CollabEvt nouveauCollabEvt =  new CollabEvt(collab.getMatricule(), type.CREATION_COLLAB, dateHeureCreation);
		collabEvt.fire(nouveauCollabEvt);
	}

}
