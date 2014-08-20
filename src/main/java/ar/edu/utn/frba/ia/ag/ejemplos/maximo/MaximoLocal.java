package main.java.ar.edu.utn.frba.ia.ag.ejemplos.maximo;

import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.BinomialMascaraComplemento;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.MutacionSimple;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.ControlSobreNumeroEsperado;

public class MaximoLocal {
	
	public static void main(String[] args) {
		
		ConfiguracionDefault c = new ConfiguracionDefault();
		
		c.setMetodoDeSeleccion(new ControlSobreNumeroEsperado());
		c.setMutacion(new MutacionSimple(0.9));
		c.setCruzamiento(new BinomialMascaraComplemento("Y"));
		
//		new CantidadDeCiclos(99L), // criterio de paro
//		999, // cantIndividuosIniciales
//		new Torneo(), // seleccion
//		new Simple(), // cruzamiento
//		new MutacionSimple(0.2)
		
		AlgoritmoGenetico maximoLocal = new AlgoritmoGenetico(c, X.class);
		
		Individuo x = maximoLocal.ejecutar();
		
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("Individuo final: " + x.toString());
		
		System.out.println("------------------------------------------------------------------------");
		
	}
	
}

