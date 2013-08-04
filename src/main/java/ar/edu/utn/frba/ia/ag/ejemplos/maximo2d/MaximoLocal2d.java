package main.java.ar.edu.utn.frba.ia.ag.ejemplos.maximo2d;

import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class MaximoLocal2d {
	
	public static void main(String[] args) {
		
		AlgoritmoGenetico maximoLocal = new AlgoritmoGenetico(new ConfiguracionDefault(), XY.class);
		
		Individuo xy = maximoLocal.ejecutar();
		
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("Individuo final: " + xy.toString());
		
	}
	
}
