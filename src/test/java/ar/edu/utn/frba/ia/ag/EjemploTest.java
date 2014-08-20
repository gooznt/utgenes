package test.java.ar.edu.utn.frba.ia.ag;

import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.Configuracion;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.paro.AptitudMinima;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.ControlSobreNumeroEsperado;

import org.junit.Assert;
import org.junit.Test;

public class EjemploTest {
	
	@Test
	public void testEjemplo() {
		
		Configuracion config = new ConfiguracionDefault();
		
		config.setPoblacionInicial(3);
		config.setMetodoDeSeleccion(new ControlSobreNumeroEsperado());
		config.setCriterioDeParo(new AptitudMinima(9.9));
		
		AlgoritmoGenetico test = new AlgoritmoGenetico(config, IndividuoDePruebaX.class);
		
		Individuo ind = test.ejecutar();
		
		System.out.println("----------------------------------------------------------");
		System.out.println("***** SOLUCION *****");
		System.out.println("Efectividad del algoritmo: " + new Double((int)(ind.aptitud()*100)) / 10 + "%");
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("Individuo final: " + ind.toString());
		
		Assert.assertTrue(ind.aptitud() > 5 && ind.aptitud() <= 10);
		
	}
}
