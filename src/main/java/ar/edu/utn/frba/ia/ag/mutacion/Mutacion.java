package main.java.ar.edu.utn.frba.ia.ag.mutacion;

import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public abstract class Mutacion {
	
	public void mutar(List<Individuo> individuos) {
		
		if (Math.random() <= this.probabilidadDeMutacion()) {
			
			Individuo individuoAleatorio = individuos.get((int)(Math.random() * individuos.size()));
			
			System.out.println("MUTA -> individuo previo: " + individuoAleatorio.toString());
			
			individuoAleatorio.mutar();
			
			System.out.println("MUTA -> nuevo individuo: " + individuoAleatorio.toString());
			
		}
	}

	protected abstract double probabilidadDeMutacion();
	
}
