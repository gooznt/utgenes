package test.java.ar.edu.utn.frba.ia.ag;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.Configuracion;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.paro.CantidadDeCiclos;
import main.java.ar.edu.utn.frba.ia.ag.paro.CriterioDeParo;

import org.junit.Assert;
import org.junit.Test;

public class AlgoritmoGeneticoTest {
	
	@Test
	public void testUnaVuelta() {
		
		CriterioDeParo paroInstantaneo = new CantidadDeCiclos(1L);
		Configuracion config = new ConfiguracionDefault();
		config.setCriterioDeParo(paroInstantaneo);
		
		AlgoritmoGenetico ag = new AlgoritmoGenetico(config, IndividuoDePrueba.class);
		Individuo resultado = ag.ejecutar();
		Assert.assertNotNull(resultado);
	}
	
	public void testCruzamiento() {
		
//		Cruzamiento.simple(individuos);
		
	}
	
	public void testLoggearEstado() {
	}
	
}
