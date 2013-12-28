package test.java.ar.edu.utn.frba.ia.ag;

import junit.framework.TestCase;
import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.Configuracion;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.paro.CantidadDeCiclos;
import main.java.ar.edu.utn.frba.ia.ag.paro.CriterioDeParo;

public class AlgoritmoGeneticoTest extends TestCase {
	
	private Configuracion configuracion = new ConfiguracionDefault();
	
	public void testAlgoritmoGenetico(Configuracion config) {
		
		this.configuracion = (config != null) ? config : configuracion;
		
		return;
	}
	
	public void testUnaVuelta() {
		
		CriterioDeParo paroInstantaneo = new CantidadDeCiclos(1L);
		Configuracion config = new ConfiguracionDefault();
		config.setCriterioDeParo(paroInstantaneo);
		
		AlgoritmoGenetico ag = new AlgoritmoGenetico(config, IndividuoDePrueba.class);
		Individuo resultado = ag.ejecutar();
		assertNotNull(resultado);
	}
	
	public void testSeleccion() {
		// ver con que metodo lo quiero seleccionar y ejecutarlo
//		Seleccion.torneo(this.individuos, configuracion.MANTENER_TAMANIO_POBLACION ? configuracion.POBLACION_INICIAL : 10);
	}
	
	public void testCruzamiento() {
		
//		Cruzamiento.simple(individuos);
		
	}
	
	public void testLoggearEstado() {
	}
	
}
