package dev.sgp.service;

import java.util.ArrayList;

import static java.util.stream.Collectors.*;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;

import dev.sgp.entite.VisiteStatistiques;
import dev.sgp.entite.VisiteWeb;

public class VisiteWebService {
	
	List<VisiteWeb> listeVisites = new ArrayList<>();
	
	public List<VisiteWeb> listerVisites() {
		return listeVisites;
	}
	
	public void sauvegarderVisite(VisiteWeb visite) {
		listeVisites.add(visite);
	}
	
	public List<VisiteStatistiques> construireStatistiques() {
		
		List<VisiteStatistiques> listVisiteStatistique = new ArrayList<>();
		
		Map<String, List<VisiteWeb>> cheminListeVisites = listeVisites.stream().collect(groupingBy(VisiteWeb::getChemin));
		
		cheminListeVisites.forEach((chemin, listeVisites) -> {
			listVisiteStatistique.add(construireVisiteStatistiques(chemin, listeVisites));
		});
		
		return listVisiteStatistique;
	}
	
	public VisiteStatistiques construireVisiteStatistiques(String chemin, List<VisiteWeb> listesVisites){
		LongSummaryStatistics  stats = listesVisites.stream().collect(summarizingLong(VisiteWeb::getTempsExecution));
		
		return new VisiteStatistiques(chemin, stats.getCount(), stats.getMin(), stats.getMax(), stats.getAverage());
	}
	
	
	

}
