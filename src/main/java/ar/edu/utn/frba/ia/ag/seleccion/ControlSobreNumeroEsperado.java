package main.java.ar.edu.utn.frba.ia.ag.seleccion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.ar.edu.utn.frba.ia.ag.Estado;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class ControlSobreNumeroEsperado extends Seleccion {
	
	Ruleta seleccionAuxiliar = new Ruleta();
	
	@Override
	protected List<Individuo> seleccion(List<Individuo> individuos, Estado estado) {
		
		Map<Individuo, Double> partesDecimales = new HashMap<Individuo, Double>();
		List<Individuo> nuevos = new ArrayList<Individuo>();
		
		for (Individuo individuo : individuos) {
			
			double aptitudSobrePromedio = individuo.aptitud() / (estado.getTotalUltimaAptitud() / individuos.size());
			
			partesDecimales.put(individuo, aptitudSobrePromedio - (int)aptitudSobrePromedio);
			
			for (int i = 0; i < (int)aptitudSobrePromedio ; i++) {
				nuevos.add(individuo.clone());
			}
		}
		
		nuevos.addAll(this.aplicarRuleta(individuos, partesDecimales, Math.abs(individuos.size() - nuevos.size())));
		
		return this.generarCopias(nuevos, estado);
	}
	
	private List<Individuo> aplicarRuleta(List<Individuo> individuos, Map<Individuo, Double> partesDecimales,  int cantResultante) {
		
		Double probabilidadAcumulada = 0D;
		Map<Double, Individuo> panio = new HashMap<Double, Individuo>();
		
		Double totalPartesDecimales = 0D;
		
		for (Individuo individuo : partesDecimales.keySet()) {
			totalPartesDecimales += partesDecimales.get(individuo);
		}
		
		if (totalPartesDecimales > 0) {
			for (Individuo individuo : individuos) {
				probabilidadAcumulada += partesDecimales.get(individuo) / totalPartesDecimales;
				panio.put(probabilidadAcumulada, individuo);
			}
		}
		
		List<Individuo> individuosSeleccionados = seleccionAuxiliar.asignarCantCopias(individuos, panio);
		
		Collections.sort(individuosSeleccionados);
		
		return individuosSeleccionados.subList(0, cantResultante);
		
	}
	
}
