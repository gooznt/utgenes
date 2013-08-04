package test.java.ar.edu.utn.frba.ia.ag;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.Cruzamiento;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.CruzamientoBinomialMascaraComplemento;

import org.junit.Test;

public class CruzamientoTest extends TestCase {
	
	@Test
	public void cruzamientoBinomialMascaraComplementoTest() {
		
		IndividuoDePrueba padre = new IndividuoDePrueba(1, 2);
		IndividuoDePrueba madre = new IndividuoDePrueba(3, 4);
		
		List<Individuo> individuos = new ArrayList<Individuo>();
		
		individuos.add(padre);
		individuos.add(madre);
		
		String mascara = "";
		
		for (int i = 0; i < individuos.getClass().getDeclaredFields().length; i++) {
			mascara.concat("X");
		}
		
		Cruzamiento cruzamiento = new CruzamientoBinomialMascaraComplemento(mascara);
		
		cruzamiento.cruzarIndividuos(individuos);
		
		assertEquals(individuos.get(0).toString(), padre.toString());
		assertEquals(individuos.get(1).toString(), madre.toString());
		
	}	
	
}
