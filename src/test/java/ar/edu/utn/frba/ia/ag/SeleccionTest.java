package test.java.ar.edu.utn.frba.ia.ag;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import main.java.ar.edu.utn.frba.ia.ag.Estado;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Ranking;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Seleccion;

import org.junit.Test;

public class SeleccionTest extends TestCase {
	
	Individuo vacio = new Individuo() {
		
		@Override
		public int compareTo(Individuo o) {
			return 0;
		}
		
		@Override
		public boolean esMasAptoQue(Individuo otroIndividuo) {
			return false;
		}
		
		@Override
		public double aptitud() {
			return 0;
		}

		@Override
		public Individuo generarRandom() {
			return null;
		}
	};
	
	@Test
	public void torneoCantMenorTest() {
		
		List<Individuo> unSoloIndividuo = new ArrayList<Individuo>();
		
		unSoloIndividuo.add(vacio);
		
		Seleccion selccion = new Ranking(2);
		assertEquals(selccion.seleccionar(unSoloIndividuo, new Estado()), unSoloIndividuo.size());
	}
	
	@Test
	public void torneoCantParTest() {
		
		List<Individuo> par = new ArrayList<Individuo>();
		
		par.add(vacio);
		par.add(vacio);
		
		Seleccion selccion = new Ranking(0);
		assertEquals(selccion.seleccionar(par, new Estado()), par);
	}
	
	@Test
	public void rankingCantMenorTest() {
		
		List<Individuo> unSoloIndividuo = new ArrayList<Individuo>();
		
		unSoloIndividuo.add(vacio);
		
		Seleccion selccion = new Ranking(0);
		assertEquals(selccion.seleccionar(unSoloIndividuo, new Estado()), unSoloIndividuo.size());
		
	}
	
	@Test
	public void rankingTest() {
	}
	
	@Test
	public void torneoTest() {
	}
	
}
