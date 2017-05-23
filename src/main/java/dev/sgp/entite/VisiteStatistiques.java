package dev.sgp.entite;

public class VisiteStatistiques {
	
	private String chemin;
	private int nbVisites;
	private long minExecution;
	private long maxExecution;
	private long moyExecution;
	
	
	
	public VisiteStatistiques(String chemin, int nbVisites, long minExecution, long maxExecution, long moyExecution) {
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
	
	public int getNbVisites() {
		return nbVisites;
	}
	
	public void setNbVisites(int nbVisites) {
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
	
	public long getMoyExecution() {
		return moyExecution;
	}
	
	public void setMoyExecution(long moyExecution) {
		this.moyExecution = moyExecution;
	}
	
	public void incrementNbVisites() {
		this.nbVisites++;
	}
	
	
}
