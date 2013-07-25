package test.java.ar.edu.utn.frba.ia.ag;

import java.util.ArrayList;
import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Configuracion;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.monedas.Monedero;

public class AlgoritmoGeneticoTest {
	
	private Configuracion configuracion = new ConfiguracionDefault();
	private List<Individuo> individuos;
	
	protected void agregarIndividuoTest(Individuo individuo) {
		
		if (individuos == null) {
			individuos = new ArrayList<Individuo>();
		}
		
		individuos.add(individuo);
		
	}
	
	public void algoritmoGeneticoTest(Configuracion config) {
		
		this.configuracion = (config != null) ? config : configuracion;
		
		return;
	}
	
	public void generarPoblacionInicialTest() {
		
	}
	
	public Individuo ejecutar() {
		return null;
	}

	private void seleccion() {
		// ver con que metodo lo quiero seleccionar y ejecutarlo
//		Seleccion.torneo(this.individuos, configuracion.MANTENER_TAMANIO_POBLACION ? configuracion.POBLACION_INICIAL : 10);
	}
	
	private void cruzamiento() {
		
//		Cruzamiento.simple(individuos);
		
	}
	
	private void mutacion() {
		
		if (Math.random() < 0.02) {
			Monedero monedas = ((Monedero)this.individuos.get(((int)(Math.random() * 10))));
			
			System.out.println("MUTAAAAAAAAAA1");
			System.out.println(monedas.toString());
			
			int nuevo = monedas.getMonedasDe1peso();
			
			monedas.setMonedasDe1peso(nuevo | 2);
			
			System.out.println("MUTAAAAAAAAAA2");
			System.out.println(monedas.toString());
		}
		
	}
	
	private void loggearEstado() {
		
		for (Individuo individuo: individuos) {
			System.err.println(individuo.toString());
		}
		
	}
	
}
