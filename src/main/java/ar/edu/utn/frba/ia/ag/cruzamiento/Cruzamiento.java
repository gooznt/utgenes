package main.java.ar.edu.utn.frba.ia.ag.cruzamiento;

import java.util.ArrayList;
import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public abstract class Cruzamiento {
	
	protected static final String X = "X";
	protected static final String Y = "Y";
	
	protected abstract void cruzar(Individuo padreA, Individuo padreB);
	
	public List<Individuo> cruzarIndividuos(List<Individuo> individuos) {
		
		List<Individuo> nuevos = new ArrayList<Individuo>();
		
		for (int i = 0; i < individuos.size() ; i++) {
			cruzar(individuos.get(i), individuos.get(individuos.size() - i - 1));
		}
		
		return nuevos;
	}
	
}
