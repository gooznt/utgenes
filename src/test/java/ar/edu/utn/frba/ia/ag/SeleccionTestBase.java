package test.java.ar.edu.utn.frba.ia.ag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Estado;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Seleccion;

import org.junit.Assert;
import org.junit.Test;

public abstract class SeleccionTestBase {
	
	protected abstract Seleccion crearSeleccion();
	
	@Test
	public void testSeleccionarUno() {
		
		List<Individuo> unicoIndividuo = new ArrayList<Individuo>();
		
		unicoIndividuo.add(new IndividuoDePrueba());
		
		Seleccion seleccion = this.crearSeleccion();
		Assert.assertEquals(seleccion.seleccionar(unicoIndividuo, new EstadoDePrueba()).get(0).aptitud(), unicoIndividuo.get(0).aptitud(), 0.25);
	}
	
	@Test
	public void testSeleccionarDos() {
		
		List<Individuo> par = new ArrayList<Individuo>();

		Individuo mejor = new IndividuoDePrueba(5, 5);
		Individuo segundoMejor = new IndividuoDePrueba(1, 1); // invierto los valores que asigno con respecto al mejor

		par.add(mejor);
		par.add(segundoMejor);

		Estado estadoDePrueba = new EstadoDePrueba();

		List<Individuo> individuosSeleccionados = this.crearSeleccion().seleccionar(par, estadoDePrueba);

		Collections.sort(individuosSeleccionados);

		for (Individuo individuo : individuosSeleccionados) {
			System.out.println("Individuo: " + individuo.toString());
		}

		Assert.assertEquals(individuosSeleccionados.get(0).aptitud(), mejor.aptitud(), 1);
		Assert.assertEquals(individuosSeleccionados.get(1).aptitud(), segundoMejor.aptitud(), 1);
	}
	
}
