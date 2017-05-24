package dev.sgp.entite;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VisiteStatistiques {
	

	@Id
	private String chemin;
	private long nbVisites;
	private long minExecution;
	private long maxExecution;
	private double moyExecution;
	
	public VisiteStatistiques(){
		
	}
	
	public VisiteStatistiques(String chemin, long nbVisites, long minExecution, long maxExecution, double moyExecution) {
		this.chemin = chemin;
		this.nbVisites = nbVisites;
		this.minExecution = minExecution;
		this.maxExecution = maxExecution;
		this.moyExecution = moyExecution;
	}

	public String getChemin() {
		return chemin;
	}
	
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}
	
	public long getNbVisites() {
		return nbVisites;
	}
	
	public void setNbVisites(long nbVisites) {
		this.nbVisites = nbVisites;
	}
	
	public long getMinExecution() {
		return minExecution;
	}
	
	public void setMinExecution(long minExecution) {
		this.minExecution = minExecution;
	}
	
	public long getMaxExecution() {
		return maxExecution;
	}
	
	public void setMaxExecution(long maxExecution) {
		this.maxExecution = maxExecution;
	}
	
	public double getMoyExecution() {
		return moyExecution;
	}
	
	public void setMoyExecution(double moyExecution) {
		this.moyExecution = moyExecution;
	}
	
	public void incrementNbVisites() {
		this.nbVisites++;
	}
	
	
}
