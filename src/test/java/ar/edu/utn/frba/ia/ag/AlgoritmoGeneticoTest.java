package test.java.ar.edu.utn.frba.ia.ag;

import main.java.ar.edu.utn.frba.ia.ag.Configuracion;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;

public class AlgoritmoGeneticoTest {
	
	private Configuracion configuracion = new ConfiguracionDefault();
	
	public void algoritmoGeneticoTest(Configuracion config) {
		
		this.configuracion = (config != null) ? config : configuracion;
		
		return;
	}
	
	public void generarPoblacionInicialTest() {
		
	}
	
	public void seleccionTest() {
		// ver con que metodo lo quiero seleccionar y ejecutarlo
//		Seleccion.torneo(this.individuos, configuracion.MANTENER_TAMANIO_POBLACION ? configuracion.POBLACION_INICIAL : 10);
	}
	
	public void cruzamientoTest() {
		
//		Cruzamiento.simple(individuos);
		
	}
	
	public void loggearEstadoTest() {
	}
	
}
