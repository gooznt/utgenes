package main.java.ar.edu.utn.frba.ia.ag.mutacion;

import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Estado;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public abstract class Mutacion {
	
	public void mutar(List<Individuo> individuos, Estado estado) {
		
		if (Math.random() <= this.getProbabilidadDeMutacion(individuos, estado)) {
			
			Individuo individuoAleatorio = individuos.get((int)(Math.random() * individuos.size()));
			
//			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info("MUTA -> individuo previo: " + individuoAleatorio.toString());

			individuoAleatorio.mutar();
			
			estado.sumarMutacion();
			
//			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info("MUTA -> nuevo individuo: " + individuoAleatorio.toString());
			
		}
	}
	
	protected abstract double getProbabilidadDeMutacion(List<Individuo> individuos, Estado estado);
	
}
