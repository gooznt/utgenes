package test.java.ar.edu.utn.frba.ia.ag;

import java.util.ArrayList;
import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.BinomialMascaraComplemento;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.Cruzamiento;

import org.junit.Assert;
import org.junit.Test;

public class CruzamientoTest {
	
	@Test
	public void testCruzamientoBinomialMascaraComplemento() {
		
		IndividuoDePrueba padre = new IndividuoDePrueba();
		IndividuoDePrueba madre = new IndividuoDePrueba();
		
		padre.setProp1(1);
		padre.setProp2(2);
		
		madre.setProp1(3);
		madre.setProp1(4);
		
		List<Individuo> individuos = new ArrayList<Individuo>();
		
		individuos.add(padre);
		individuos.add(madre);
		
		String mascara = "";
		
		for (int i = 0; i < padre.getClass().getDeclaredFields().length; i++) {
			mascara += "X";
		}
		
		Cruzamiento cruzamiento = new BinomialMascaraComplemento(mascara);
		
		cruzamiento.cruzarIndividuos(individuos);
		
		Assert.assertEquals(individuos.get(0).toString(), padre.toString());
		Assert.assertEquals(individuos.get(1).toString(), madre.toString());
		
	}	
	
}
