package main.java.ar.edu.utn.frba.ia.ag.paro;

import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class CantidadDeCiclos extends CriterioDeParo {
	
	private Long ciclosTranscurridos;
	private Long totalCiclos;
	
	public CantidadDeCiclos(Long totalCiclos) {
		this.totalCiclos = totalCiclos;
		this.ciclosTranscurridos = new Long(0);
	}
	
	@Override
	public Boolean parar(List<Individuo> individuos) {
		
		if (totalCiclos.equals(ciclosTranscurridos)) {
			return Boolean.TRUE;
		}
		
		ciclosTranscurridos++;
		
		return Boolean.FALSE;
	}
}
