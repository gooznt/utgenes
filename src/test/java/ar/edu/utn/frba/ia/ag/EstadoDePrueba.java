package test.java.ar.edu.utn.frba.ia.ag;

import main.java.ar.edu.utn.frba.ia.ag.Estado;

public class EstadoDePrueba extends Estado {
	
	public EstadoDePrueba() {
		this.agregarAptitudesPromedio(0D);
		this.agregarMejorIndividuo(new IndividuoDePrueba());
		this.agregarPeorIndividuo(new IndividuoDePrueba());
		this.agregarTotalAptitudes(0D);
	}
	
}
