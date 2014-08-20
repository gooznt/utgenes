package test.java.ar.edu.utn.frba.ia.ag;

import main.java.ar.edu.utn.frba.ia.ag.Configuracion;
import main.java.ar.edu.utn.frba.ia.ag.Configuracion5Min;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.Simple;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.MutacionSimple;
import main.java.ar.edu.utn.frba.ia.ag.paro.CantidadDeCiclos;
import main.java.ar.edu.utn.frba.ia.ag.paro.TiempoTranscurrido;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Torneo;

import org.junit.Assert;
import org.junit.Test;


public class ConfiguracionTest {
	
	@Test
	public void testConfiguracion5Min() {
		
		Configuracion config = new Configuracion5Min();
		
		Assert.assertFalse(config.getCriterioDeParo().parar(null));
		Assert.assertEquals(TiempoTranscurrido.class.getName(), config.getCriterioDeParo().getClass().getName());
		
		Assert.assertEquals(MutacionSimple.class.getName(), config.getMutacion().getClass().getName());
		Assert.assertEquals(Simple.class.getName(), config.getCruzamiento().getClass().getName());
		Assert.assertEquals(Torneo.class.getName(), config.getMetodoDeSeleccion().getClass().getName());
		Assert.assertEquals(999, config.getPoblacionInicial());
		
	}
	
	@Test
	public void testConfiguracionDefault() {
		
		Configuracion config = new ConfiguracionDefault();
		
		Assert.assertFalse(config.getCriterioDeParo().parar(null));
		Assert.assertEquals(CantidadDeCiclos.class.getName(), config.getCriterioDeParo().getClass().getName());
		
		Assert.assertEquals(MutacionSimple.class.getName(), config.getMutacion().getClass().getName());
		Assert.assertEquals(Simple.class.getName(), config.getCruzamiento().getClass().getName());
		Assert.assertEquals(Torneo.class.getName(), config.getMetodoDeSeleccion().getClass().getName());
		Assert.assertEquals(999, config.getPoblacionInicial());
		
	}
	
}
