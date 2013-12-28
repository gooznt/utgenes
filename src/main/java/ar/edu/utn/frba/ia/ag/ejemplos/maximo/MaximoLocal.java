package main.java.ar.edu.utn.frba.ia.ag.ejemplos.maximo;

import java.util.List;
import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Estado;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.BinomialAzar;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.BinomialAzarComplemento;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.BinomialMascaraComplemento;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.MultiPunto;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.Simple;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.SimplePuntoFijo;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.Mutacion;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.MutacionAdaptativaPorConvergencia;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.MutacionSimple;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.MutacionTemperaturaAscendente;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.MutacionTemperaturaDescendente;
import main.java.ar.edu.utn.frba.ia.ag.paro.CantidadDeCiclos;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.ControlSobreNumeroEsperado;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Ranking;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Ruleta;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Torneo;

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

