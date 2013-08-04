package main.java.ar.edu.utn.frba.ia.ag.seleccion;

import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public abstract class Seleccion {
	
	public List<Individuo> seleccionar(List<Individuo> individuos, int cantSeleccion) {
		
		return this.seleccion(individuos, cantSeleccion);
		
	}
	
	protected abstract List<Individuo> seleccion(List<Individuo> individuos, int cantSeleccion);
	
}
