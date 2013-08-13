package main.java.ar.edu.utn.frba.ia.ag.seleccion;

import java.util.ArrayList;
import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Estado;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class Torneo extends Seleccion {
	
	@Override
	protected List<Individuo> seleccion(List<Individuo> individuos, Estado estado) {
		
		List<Individuo> nuevos = new ArrayList<Individuo>();
		
		for (int i = 0; i < individuos.size() ; i++) {
			
			if (individuos.get(i).esMasAptoQue(individuos.get(individuos.size() - i - 1))) {
				nuevos.add(individuos.get(i));
			}
			else {
				nuevos.add(individuos.get(individuos.size() - i - 1));
			}
		}
		
		return this.generarCopias(nuevos, estado);
	}
}
