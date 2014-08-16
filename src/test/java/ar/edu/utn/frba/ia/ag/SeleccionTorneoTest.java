package test.java.ar.edu.utn.frba.ia.ag;

import main.java.ar.edu.utn.frba.ia.ag.seleccion.Seleccion;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Torneo;

public class SeleccionTorneoTest extends SeleccionTestBase {

	@Override
	protected Seleccion crearSeleccion() {
		return new Torneo();
	}
	
}
