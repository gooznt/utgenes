package main.java.ar.edu.utn.frba.ia.ag.mutacion;

import java.util.List;
import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public abstract class Mutacion {
	
	public void mutar(List<Individuo> individuos) {
		
		if (Math.random() <= this.probabilidadDeMutacion()) {
			
			Individuo individuoAleatorio = individuos.get((int)(Math.random() * individuos.size()));
			
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info("MUTA -> individuo previo: " + individuoAleatorio.toString());

			individuoAleatorio.mutar();
			
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info("MUTA -> nuevo individuo: " + individuoAleatorio.toString());
			
		}
	}

	protected abstract double probabilidadDeMutacion();
	
}
