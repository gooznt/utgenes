package main.java.ar.edu.utn.frba.ia.ag.seleccion;

import java.util.ArrayList;
import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Estado;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.UTgeNesUtils;

public abstract class Seleccion {
	
	public List<Individuo> seleccionar(List<Individuo> individuos, Estado estado) {
		
		return this.seleccion(individuos, estado);
	}
	
	/**
	 * Genera una cantidad de copias de acuerdo al tamaño de la población que necesito
	 * Si le paso menos individuos, me duplica los necesarios de acuerdo a la aptitud
	 * */
	protected List<Individuo> generarCopias(List<Individuo> individuos, Estado estado) {
		
		List<Individuo> copias = new ArrayList<Individuo>();
		
		for (Individuo individuo : individuos) {
			for (int i = 0; i < Math.round(individuo.aptitud() * individuos.size() / estado.getTotalUltimaAptitud()); i++) {
				copias.add(individuo.clone());
			}
		}
		
		while (copias.size() > individuos.size()) { // si me sobran individuos, elimino al azar
			copias.remove(UTgeNesUtils.alguno(copias.toArray()));
		}
		
		while (copias.size() < individuos.size()) { // si me faltan individuos, clono al azar
			copias.add(((Individuo)UTgeNesUtils.alguno(individuos.toArray())).clone());
		}
		
		return copias;
	}
	
	protected abstract List<Individuo> seleccion(List<Individuo> individuos, Estado estado);
	
}
