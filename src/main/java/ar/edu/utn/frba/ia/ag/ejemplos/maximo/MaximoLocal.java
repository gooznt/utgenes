package main.java.ar.edu.utn.frba.ia.ag.ejemplos.maximo;

import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class MaximoLocal {
	
	public static void main(String[] args) {
		
		AlgoritmoGenetico maximoLocal = new AlgoritmoGenetico(new ConfiguracionDefault(), X.class);
		
		Individuo x = maximoLocal.ejecutar();
		
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("Individuo final: " + x.toString());
		
	}
	
}
