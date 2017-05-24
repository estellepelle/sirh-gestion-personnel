package dev.sgp.entite;

import java.time.ZonedDateTime;

public class CollabEvt {
	
	private String matricule;
	private TypeCollabEvt type;
	private ZonedDateTime dateHeure;
	
	
	
	public CollabEvt(String matricule, TypeCollabEvt type, ZonedDateTime dateHeure) {
		this.matricule = matricule;
		this.type = type;
		this.dateHeure = dateHeure;
	}

	public String getMatricule() {
		return matricule;
	}
	
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public TypeCollabEvt getType() {
		return type;
		
	}
	
	public void setType(TypeCollabEvt type) {
		this.type = type;
	}
	
	public ZonedDateTime getDateHeure() {
		return dateHeure;
	}
	
	public void setDateHeure(ZonedDateTime dateHeure) {
		this.dateHeure = dateHeure;
	}
	
	
}
