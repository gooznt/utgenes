package main.java.ar.edu.utn.frba.ia.ag.ejemplos.optimizacion;

import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.Configuracion;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.ControlSobreNumeroEsperado;

public class Optimizacion {
	
	public static void main(String[] args) {
		
		Configuracion config = new ConfiguracionDefault();
		config.setMetodoDeSeleccion(new ControlSobreNumeroEsperado());
		
		AlgoritmoGenetico maximoLocal = new AlgoritmoGenetico(config, Combinaciones.class);
		
		Individuo xyz = maximoLocal.ejecutar();
		
		System.out.println("----------------------------------------------------------");
		System.out.println("***** SOLUCION *****");
		System.out.println("Efectividad del algoritmo: " + new Double((int)((xyz.aptitud()*100/2334.28)*100)) / 100 + "%");
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("Individuo final: " + xyz.toString());
		
		// Resultado Esperado https://docs.google.com/drawings/d/1i5sv1zcMGIulYWkuLcAv6UQV5haLKlKHm_FgiDWXdG0
//		
//		Solución Optima:
//		
//		H			0.000000
//		S			98.57143
//		U			95.71429
//		Ganancia    2334.286
		
	}
}
