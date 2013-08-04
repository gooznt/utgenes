package main.java.ar.edu.utn.frba.ia.ag.seleccion;

import java.util.ArrayList;
import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class Torneo extends Seleccion {
	
	@Override
	protected List<Individuo> seleccion(List<Individuo> individuos, int cantSeleccion) {
		
		if (cantSeleccion > individuos.size()) {
			return individuos;
		}
		
		List<Individuo> nuevos = new ArrayList<Individuo>();
		
		for (int i = 0; i < cantSeleccion ; i++) {
			
			if (individuos.get(i).esMasAptoQue(individuos.get(individuos.size() - i - 1))) {
				nuevos.add(individuos.get(i));
			}
			else {
				nuevos.add(individuos.get(individuos.size() - i - 1));
			}
		}
		
		return nuevos;
	}
}
