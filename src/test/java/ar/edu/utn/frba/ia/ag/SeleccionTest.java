package test.java.ar.edu.utn.frba.ia.ag;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import main.java.ar.edu.utn.frba.ia.ag.Estado;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Ranking;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Seleccion;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Torneo;

import org.junit.Test;

public class SeleccionTest extends TestCase {
	
	@Test
	public void testTorneoCantMenor() {
		
		List<Individuo> unicoIndividuo = new ArrayList<Individuo>();
		
		unicoIndividuo.add(new IndividuoDePrueba());
		
		Seleccion selccion = new Torneo();
		assertEquals(selccion.seleccionar(unicoIndividuo, new EstadoDePrueba()).size(), unicoIndividuo.size());
	}
	
	@Test
	public void testTorneoCantPar() {
		
		List<Individuo> par = new ArrayList<Individuo>();
		
		par.add(new IndividuoDePrueba());
		par.add(new IndividuoDePrueba());
		
		Seleccion selccion = new Ranking(0);
		assertEquals(selccion.seleccionar(par, new Estado()), par);
	}
	
	@Test
	public void testRankingCantMenor() {
		
		List<Individuo> unSoloIndividuo = new ArrayList<Individuo>();
		
		unSoloIndividuo.add(new IndividuoDePrueba());
		
		Seleccion selccion = new Ranking(0);
		assertEquals(selccion.seleccionar(unSoloIndividuo, new EstadoDePrueba()).size(), unSoloIndividuo.size());
		
	}
	
	@Test
	public void testRanking() {
	}
	
	@Test
	public void testTorneo() {
	}
	
}
