package main.java.ar.edu.utn.frba.ia.ag.ejemplos.maximo2d;

import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.Configuracion;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.paro.TiempoTranscurrido;

public class Optimizacion {
	
	public static void main(String[] args) {
		
		Configuracion config = new ConfiguracionDefault();
		config.setCriterioDeParo(new TiempoTranscurrido(0, 5, 0));
		
		AlgoritmoGenetico maximoLocal = new AlgoritmoGenetico(config, Combinaciones.class);
		
		Individuo xyz = maximoLocal.ejecutar();
		
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("Individuo final: " + xyz.toString());
		
	}
	
}
