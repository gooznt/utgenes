package main.java.ar.edu.utn.frba.ia.ag.mutacion;

import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Estado;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class MutacionAdaptativaPorConvergencia extends Mutacion {
	
	@Override
	protected double getProbabilidadDeMutacion(List<Individuo> individuos, Estado estado) {
		
		Individuo mejorIndividuo = estado.getMejoresIndividuos().get(estado.getMejoresIndividuos().size() - 1);
		Individuo peorIndividuo = estado.getPeoresIndividuos().get(estado.getPeoresIndividuos().size() - 1);
		
		// cuanto más distancia haya entre el mejor y el peor de los individuos, aumento la probabilidad de mutación
		double diferenciaMejorPeor = mejorIndividuo.aptitud() - peorIndividuo.aptitud();
		
		return 1.0 - 1 /(diferenciaMejorPeor / estado.getAptitudesPromedio().get(estado.getAptitudesPromedio().size() - 1));
		
	}
	
}
