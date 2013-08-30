package main.java.ar.edu.utn.frba.ia.ag.seleccion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.ar.edu.utn.frba.ia.ag.Estado;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class Ruleta extends Seleccion {
	
	@Override
	protected List<Individuo> seleccion(List<Individuo> individuos, Estado estado) {
		
		Map<Double, Individuo> panio = generarPanio(individuos, estado);
		
		List<Individuo> nuevos = asignarCantCopias(individuos, panio);
		
		return this.generarCopias(nuevos, estado);
	}
	
	public List<Individuo> asignarCantCopias(List<Individuo> individuos, Map<Double, Individuo> panio) {
		
		List<Individuo> nuevos = new ArrayList<Individuo>();
		
		if (!panio.isEmpty()) {
			
			List<Double> probabilidadesAcumuladas = new ArrayList<Double>(panio.keySet());
			Collections.sort(probabilidadesAcumuladas);
			
			for (int j = 0; j < individuos.size(); j++) {
				
				Double jugadaRuleta = Math.random();
				int i = 0;
				
				while (jugadaRuleta > probabilidadesAcumuladas.get(i)) {
					i++;
				}
				
				nuevos.add(panio.get(probabilidadesAcumuladas.get(i)).clone());
			}
		}
		
		return nuevos;
	}
	
	private Map<Double, Individuo> generarPanio(List<Individuo> individuos, Estado estado) {
		
		Double probabilidadAcumulada = 0D;
		Map<Double, Individuo> panio = new HashMap<Double, Individuo>();
		
		for (Individuo individuo : individuos) {
			probabilidadAcumulada += individuo.aptitud() / estado.getTotalUltimaAptitud();
			panio.put(probabilidadAcumulada, individuo);
		}
		
		return panio;
	}
}
