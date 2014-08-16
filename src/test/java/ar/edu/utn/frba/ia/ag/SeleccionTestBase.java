package test.java.ar.edu.utn.frba.ia.ag;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Seleccion;

import org.junit.Test;

public abstract class SeleccionTestBase extends TestCase {
	
	protected abstract Seleccion crearSeleccion();
	
	@Test
	public void testSeleccionarUno() {
		
		List<Individuo> unicoIndividuo = new ArrayList<Individuo>();
		
		unicoIndividuo.add(new IndividuoDePrueba());
		
		Seleccion selccion = this.crearSeleccion();
		assertEquals(selccion.seleccionar(unicoIndividuo, new EstadoDePrueba()).get(0).aptitud(), unicoIndividuo.get(0).aptitud());
	}
	
	@Test
	public void testSeleccionarDos() {
		
		List<Individuo> par = new ArrayList<Individuo>();
		
		par.add(new IndividuoDePrueba());
		par.add(new IndividuoDePrueba());
		
		Individuo mejor = par.get(0).esMasAptoQue(par.get(1)) ? par.get(0) : par.get(1);
		
		Seleccion selccion = this.crearSeleccion();
		assertEquals(selccion.seleccionar(par, new EstadoDePrueba()).get(0).aptitud(), mejor);
		assertEquals(selccion.seleccionar(par, new EstadoDePrueba()).get(1).aptitud(), mejor);
	}
	
}
