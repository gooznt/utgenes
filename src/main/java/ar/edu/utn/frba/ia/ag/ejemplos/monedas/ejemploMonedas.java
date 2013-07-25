package main.java.ar.edu.utn.frba.ia.ag.ejemplos.monedas;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class ejemploMonedas {
	
	public static void main(String[] args) {
		
		AlgoritmoGenetico cambioMonedas = new AlgoritmoGenetico(new ConfiguracionDefault(), Monedero.class);
		
		Individuo monedas = cambioMonedas.ejecutar();
		
		System.err.println("Individuo resultado final: " + monedas.aptitud());
		
	}
	
}
