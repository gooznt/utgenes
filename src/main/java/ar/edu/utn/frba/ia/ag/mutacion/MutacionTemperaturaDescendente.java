package main.java.ar.edu.utn.frba.ia.ag.mutacion;

import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Estado;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class MutacionTemperaturaDescendente extends Mutacion {
	
	@Override
	protected double getProbabilidadDeMutacion(List<Individuo> individuos, Estado estado) {
		
		return 1.0 / (estado.getCorridas() > 0 ? estado.getCorridas() : 1);
	}
	
}
