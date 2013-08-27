package test.java.ar.edu.utn.frba.ia.ag.testEjemplo;

import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.Configuracion;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.ControlSobreNumeroEsperado;

public class Test {
	
	public static void main(String[] args) {
		
		Configuracion config = new ConfiguracionDefault();
		
		config.setPoblacionInicial(5);
//		config.setMetodoDeSeleccion(new Ruleta());
		config.setMetodoDeSeleccion(new ControlSobreNumeroEsperado());
		
		AlgoritmoGenetico test = new AlgoritmoGenetico(config, IndividuoDePrueba.class);
		
		Individuo ind = test.ejecutar();
		
		System.out.println("----------------------------------------------------------");
		System.out.println("***** SOLUCION *****");
		System.out.println("Efectividad del algoritmo: " + new Double((int)((ind.aptitud()*100/100)*100)) / 100 + "%");
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("Individuo final: " + ind.toString());
		
	}
}
