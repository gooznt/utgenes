package main.java.ar.edu.utn.frba.ia.ag.paro;

import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class AptitudMinima extends CriterioDeParo {
	
	private double aptitudMinima = Double.MAX_VALUE;
	
	public AptitudMinima(double aptitudMinima) {
		this.aptitudMinima = aptitudMinima;
	}
	
	@Override
	public Boolean parar(List<Individuo> individuos) {
		
		for (Individuo individuo : individuos) {
			if (individuo.aptitud() > aptitudMinima) {
				return Boolean.TRUE;
			}
		}
		
		return Boolean.FALSE;
	}
	
}
