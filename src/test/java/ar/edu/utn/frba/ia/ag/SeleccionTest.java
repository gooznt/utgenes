package test.java.ar.edu.utn.frba.ia.ag;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.MetodoDeSeleccion;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Ranking;

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
		
		List<Individuo> unitaria = new ArrayList<Individuo>();
		
		unitaria.add(vacio);
		
		MetodoDeSeleccion selccion = new Ranking();
		assertEquals(selccion.seleccionar(unitaria, 0), unitaria.size());
	}
	
	@Test
	public void torneoCantParTest() {
		
		List<Individuo> par = new ArrayList<Individuo>();
		
		par.add(vacio);
		par.add(vacio);
		
		MetodoDeSeleccion selccion = new Ranking();
		assertEquals(selccion.seleccionar(par, 2), par);
	}
	
	@Test
	public void rankingCantMenorTest() {
		
		List<Individuo> unitaria = new ArrayList<Individuo>();
		
		unitaria.add(vacio);
		
		MetodoDeSeleccion selccion = new Ranking();
		assertEquals(selccion.seleccionar(unitaria, 0), unitaria.size());
		
	}
	
	@Test
	public void rankingTest() {
	}
	
	@Test
	public void torneoTest() {
	}
	
}
