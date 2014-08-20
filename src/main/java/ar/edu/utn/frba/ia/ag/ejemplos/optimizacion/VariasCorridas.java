package main.java.ar.edu.utn.frba.ia.ag.ejemplos.optimizacion;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.Configuracion;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class VariasCorridas {
	
	public static void main(String[] args) {
		
		List<Individuo> ganadores = new ArrayList<Individuo>();
		
		for (int i = 0; i < 100; i++) {
		
			Configuracion config = new ConfiguracionDefault();

			AlgoritmoGenetico maximoLocal = new AlgoritmoGenetico(config, Combinaciones.class);
			
			Individuo xyz = maximoLocal.ejecutar();
			
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("Individuo final: " + xyz.toString());
			
			ganadores.add(xyz);
			
			// Resultado Esperado https://docs.google.com/drawings/d/1i5sv1zcMGIulYWkuLcAv6UQV5haLKlKHm_FgiDWXdG0
			
		}
		
		System.out.println("----------------------------------------------------------");
		System.out.println("***** LOS GANADORES *****");
		
		for (Individuo individuo : ganadores) {
			
			System.out.println(individuo.toString());
			
		}
		System.out.println("----------------------------------------------------------");
		
	}
}
