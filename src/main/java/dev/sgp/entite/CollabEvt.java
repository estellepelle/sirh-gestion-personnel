package dev.sgp.entite;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CollabEvt {
	
	@Id
	private String matricule;
	private TypeCollabEvt type;
	private ZonedDateTime dateHeure;
	
	public CollabEvt(){
		
	}
	
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
