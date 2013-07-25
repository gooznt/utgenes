package main.java.ar.edu.utn.frba.ia.ag.paro;

import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class AptitudMinimaPromedio extends CriterioDeParo {
	
	private double aptitudMinimaPromedio = Double.MAX_VALUE;
	
	public AptitudMinimaPromedio(double aptitudMinimaPromedio) {
		this.aptitudMinimaPromedio = aptitudMinimaPromedio;
	}
	
	@Override
	public Boolean parar(List<Individuo> individuos) {
		
		double totalAptitud = 0;
		
		for (Individuo individuo : individuos) {
			totalAptitud += individuo.aptitud();
		}
		
		if (totalAptitud / individuos.size() >= aptitudMinimaPromedio) {
			return Boolean.TRUE;
		}
		else {
			return Boolean.FALSE;
		}
	}
	
}
