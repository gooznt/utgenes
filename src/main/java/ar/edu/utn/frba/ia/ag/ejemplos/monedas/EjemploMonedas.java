package main.java.ar.edu.utn.frba.ia.ag.ejemplos.monedas;

import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class EjemploMonedas {
	
	public static void main(String[] args) {
		
		AlgoritmoGenetico cambioMonedas = new AlgoritmoGenetico(new ConfiguracionDefault(), Monedero.class);
		
		Individuo monedas = cambioMonedas.ejecutar();
		
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("Individuo final: " + monedas.toString());
		
	}
	
}
