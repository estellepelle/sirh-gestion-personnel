package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.VisiteStatistiques;
import dev.sgp.entite.VisiteWeb;

public class VisiteWebService {
	
	List<VisiteWeb> listeVisites = new ArrayList<>();
	
	List<VisiteStatistiques> statVisites = new ArrayList<>();
	
	

	public List<VisiteWeb> listerVisites() {
		return listeVisites;
	}
	
	public void sauvegarderVisite(VisiteWeb visite) {
		listeVisites.add(visite);
	}
	
	public List<VisiteStatistiques> listerStatVisites() {
		return statVisites;
	}
	
	public void sauvegarderStatVisite(VisiteStatistiques laVisite) {
		statVisites.add(laVisite);
	}
	
	

}
