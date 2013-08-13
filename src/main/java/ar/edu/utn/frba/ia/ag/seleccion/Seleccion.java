package main.java.ar.edu.utn.frba.ia.ag.seleccion;

import java.util.ArrayList;
import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Estado;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public abstract class Seleccion {
	
	public List<Individuo> seleccionar(List<Individuo> individuos, Estado estado) {
		
		return this.seleccion(individuos, estado);
	}
	
	protected List<Individuo> generarCopias(List<Individuo> individuos, Estado estado) {
		
		List<Individuo> copias = new ArrayList<Individuo>();
		
		for (Individuo individuo : individuos) {
			for (int i = 0; i < individuo.aptitud() * 100 / estado.getTotalUltimaAptitud(); i++) {
				copias.add(individuo.clone());
			}
		}
		
		return copias;
	}
	
	protected abstract List<Individuo> seleccion(List<Individuo> individuos, Estado estado);
	
}
