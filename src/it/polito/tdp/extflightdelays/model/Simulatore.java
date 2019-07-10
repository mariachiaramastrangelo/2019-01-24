package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

public class Simulatore {
	
	//coda degli eventi
	private PriorityQueue<Evento> queue;
	
	//modello del mondo
	private Map<String, Integer> turistiPaese;
	
	//parametri di simulazione
	private int G; // numero di giorni
	private int T; //numero di turisti
	private String paesePartenza;
	
	private DefaultDirectedWeightedGraph<String, DefaultWeightedEdge> grafo;
	
	public void init( int T,int G, String paesePartenza, DefaultDirectedWeightedGraph<String, DefaultWeightedEdge> grafo) {
		queue= new PriorityQueue<>();
		turistiPaese= new HashMap<String, Integer>();
		this.G= G;
		this.T= T;
		this.paesePartenza= paesePartenza;
		this.grafo= grafo;
		queue.add(new Evento(1, paesePartenza,T));
		
	}
	public void run() {
		//estraggo un evento per volta dalla coda
		Evento e;
		while ((e= queue.poll())!=null) {
			List<DefaultWeightedEdge> uscenti= new ArrayList<DefaultWeightedEdge>(grafo.outgoingEdgesOf(e.getPaese()));
			double totale= calcolaPesiTotaliUscenti(uscenti);
			for(DefaultWeightedEdge dwe: uscenti) {
				//condizione per finire di aggiungere eventi
				if(e.getGiorno()<=G) {
					double peso=  grafo.getEdgeWeight(dwe);
					double percentuale= peso/totale;
					int turistispostati= (int) (Math.round(percentuale)*e.getNumeroTuristi());
					queue.add(new Evento(e.getGiorno()+1, grafo.getEdgeTarget(dwe), turistispostati));
				}
			}
			if (e.getGiorno()==G) {
				turistiPaese.put(e.getPaese(), e.getNumeroTuristi());
			}	
				
		}
		
	}
	private int calcolaPesiTotaliUscenti(List<DefaultWeightedEdge> uscenti) {
		int totale=0;
		for(DefaultWeightedEdge ed: uscenti) {
			totale += grafo.getEdgeWeight(ed);
		}
		return totale;
	}
	public Map<String, Integer> turistiPerPaese(){
		return turistiPaese;
	}

}
