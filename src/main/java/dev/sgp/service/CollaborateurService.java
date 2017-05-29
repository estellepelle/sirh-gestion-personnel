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

	@PersistenceContext(unitName = "sgp-pu")
	private EntityManager em;

	ZonedDateTime dateHeureCreation = ZonedDateTime.now();
	TypeCollabEvt type;

	@Inject
	Event<CollabEvt> collabEvt;
	@Inject
	private CollaborateurService collabService;

	public List<Collaborateur> listerCollaborateurs(Integer dep) {

		List<Collaborateur> listeCollaborateur = new ArrayList<>();

		if (dep == null) {
			TypedQuery<Collaborateur> query = em.createQuery("SELECT c FROM Collaborateur c", Collaborateur.class);

			listeCollaborateur = query.getResultList();

		} else {

			TypedQuery<Collaborateur> query = em
					.createQuery("SELECT c FROM Collaborateur c WHERE c.departement.id =:dep", Collaborateur.class)
					.setParameter("dep", dep);

			listeCollaborateur = query.getResultList();

		}

		return listeCollaborateur;
	}

	public Collaborateur leCollaborateur(String matricule) {

		TypedQuery<Collaborateur> query = em
				.createQuery("SELECT c FROM Collaborateur c WHERE c.matricule =:matricule", Collaborateur.class)
				.setParameter("matricule", matricule);

		return query.getSingleResult();
	}

	public void sauvegarderCollaborateur(Collaborateur collab) {

		em.persist(collab);

		CollabEvt nouveauCollabEvt = new CollabEvt(collab.getMatricule(), type.CREATION_COLLAB, dateHeureCreation);
		collabEvt.fire(nouveauCollabEvt);
	}

	public void modifCollaborateur(String matricule, Collaborateur collab) {
		Collaborateur collaborateur = collabService.leCollaborateur(matricule);

		if (collaborateur != null) {

			CollabEvt nouveauCollabEvt = new CollabEvt();

			nouveauCollabEvt.setMatricule(collab.getMatricule());
			nouveauCollabEvt.setDateHeure(collab.getDateHeureCreation());
			nouveauCollabEvt.setType(TypeCollabEvt.MODIFICATION_COLLAB);

			collaborateur.setEmailPro(collab.getEmailPro());
			collaborateur.setPhoto(collab.getPhoto());

			collabEvt.fire(nouveauCollabEvt);
		}
	}

	public List<String> afficheBanque(String matricule) {

		List<String> donneesBanque = new ArrayList<>();

		donneesBanque.add(collabService.leCollaborateur(matricule).getNomBanque());
		donneesBanque.add(collabService.leCollaborateur(matricule).getIban());
		donneesBanque.add(collabService.leCollaborateur(matricule).getBic());

		return donneesBanque;

	}

	public void modifDonneBanque(String matricule, Collaborateur collab) {
		Collaborateur collaborateur = collabService.leCollaborateur(matricule);

		if (collaborateur != null) {

			collaborateur.setNomBanque(collab.getNomBanque());
			collaborateur.setBic(collab.getBic());
			collaborateur.setIban(collab.getIban());

		}
	}

}
