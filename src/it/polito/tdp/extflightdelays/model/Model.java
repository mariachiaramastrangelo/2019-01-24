package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	ExtFlightDelaysDAO dao;
	DefaultDirectedWeightedGraph<String, DefaultWeightedEdge> grafo;
	
	public Model() {
		dao= new ExtFlightDelaysDAO();
	}
	
	public void creaGrafo() {
		grafo= new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(grafo, dao.listAllStates());
		for(Adiacenze a: dao.getAllAdiacenze()) {
			Graphs.addEdgeWithVertices(grafo, a.getState1(), a.getState2(), a.getNumeroVoli());
		}
		
	}
	
	public List<String> listAllStates(){
		return dao.listAllStates();
	}
	
	public String grafoCreato() {
		return "Grafo creato!\nNumero vertici: "+grafo.vertexSet().size()+"\nNumero archi:"+grafo.edgeSet().size();
	}
	
	public List<Raggiungibili> statiRaggiongibili(String partenza){
		List<DefaultWeightedEdge> outgoing = new ArrayList<DefaultWeightedEdge>(grafo.outgoingEdgesOf(partenza));
		List<Raggiungibili> raggiungibili= new ArrayList<>();
		for(DefaultWeightedEdge de: outgoing) {
			Raggiungibili raggiungibile= new Raggiungibili(grafo.getEdgeTarget(de), (int)(grafo.getEdgeWeight(de)));
			raggiungibili.add(raggiungibile);
		}
		Collections.sort(raggiungibili);
		return raggiungibili;
	}

}
