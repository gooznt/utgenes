package test.java.ar.edu.utn.frba.ia.ag;

import main.java.ar.edu.utn.frba.ia.ag.seleccion.Ranking;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Seleccion;

public class SeleccionRankingTest extends SeleccionTestBase {
	
	@Override
	protected Seleccion crearSeleccion() {
		return new Ranking(2);
	}
	
}
