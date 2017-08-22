package test.java.ar.edu.utn.frba.ia.ag;

import main.java.ar.edu.utn.frba.ia.ag.Estado;

public class EstadoDePrueba extends Estado {

	public EstadoDePrueba() {

		IndividuoDePrueba individuo1 = new IndividuoDePrueba();
		IndividuoDePrueba individuo2 = new IndividuoDePrueba();

		this.agregarMejorIndividuo(individuo1);
		this.agregarPeorIndividuo(individuo2);

		this.agregarTotalAptitudes(individuo1.aptitud() + individuo2.aptitud());
		this.agregarAptitudesPromedio((individuo1.aptitud() + individuo2.aptitud()) / 2);
	}

}
