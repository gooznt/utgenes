package main.java.ar.edu.utn.frba.ia.ag.seleccion;

import java.util.Collections;
import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class Ranking extends MetodoDeSeleccion {

	@Override
	protected List<Individuo> seleccion(List<Individuo> individuos, int cantSeleccion) {
		
		if (cantSeleccion > individuos.size()) {
			return individuos;
		}
		
		// Ordeno según la función de aptitud
		Collections.sort(individuos);
		
		// Tengo en cuenta la cantidad que quiero seleccionar y elimino los restantes
		while (individuos.size() > cantSeleccion) {
			individuos.remove(individuos.size() - 1);
		}
		
		return individuos;
	}
}
