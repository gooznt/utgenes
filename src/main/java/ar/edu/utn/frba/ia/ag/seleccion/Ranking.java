package main.java.ar.edu.utn.frba.ia.ag.seleccion;

import java.util.Collections;
import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Estado;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class Ranking extends Seleccion {
	
	Integer cantSeleccion;
	
	public Ranking(Integer cantSeleccion) {
		this.cantSeleccion = cantSeleccion;
	}
	
	@Override
	protected List<Individuo> seleccion(List<Individuo> individuos, Estado estado) {
		
		// Ordeno según la función de aptitud
		Collections.sort(individuos);
		
		// Tengo en cuenta la cantidad que quiero seleccionar y elimino los restantes
		while (individuos.size() > this.cantSeleccion) {
			individuos.remove(individuos.size() - 1);
		}
		
		return this.generarCopias(individuos, estado);
	}
	
}
