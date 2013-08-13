package main.java.ar.edu.utn.frba.ia.ag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Estado {
	
	private List<Double> aptitudesPromedio;
	private List<Double> totalAptitudes;
	private List<Individuo> individuosDestacados;
	private int ciclos = 0;
	
	public void agregarTotalAptitudes(Double totalAptitudes) {
		
		if (this.totalAptitudes == null) {
			this.totalAptitudes = new ArrayList<Double>();
		}
		
		this.totalAptitudes.add(totalAptitudes);
	}
	
	public void agregarAptitudesPromedio(double promedio) {
		
		if (this.aptitudesPromedio == null) {
			this.aptitudesPromedio = new ArrayList<Double>();
		}
		
		this.aptitudesPromedio.add(promedio);
	}
	public void agregarIndividuosDestacados(Individuo individuoDestacado) {
		
		if (this.individuosDestacados == null) {
			this.individuosDestacados = new ArrayList<Individuo>();
		}
		
		this.individuosDestacados.add(individuoDestacado);
	}
	
	public Individuo getMejorIndividuoDestacado() {
		
		List<Individuo> mejorIndividuosDestacados = this.individuosDestacados; // para no romer el orden original
		
		Collections.sort(mejorIndividuosDestacados);
		
		return mejorIndividuosDestacados.get(0);
	}
	
	public List<Individuo> getIndividuosDestacados() {
		return individuosDestacados;
	}

	public List<Double> getAptitudesPromedio() {
		return aptitudesPromedio;
	}
	
	public List<Double> getTotalAptitudes() {
		return totalAptitudes;
	}
	
	public Double getTotalUltimaAptitud() {
		return totalAptitudes.get(totalAptitudes.size() - 1);
	}

	public int getCiclos() {
		return ciclos;
	}

	public void setCiclos(int ciclos) {
		this.ciclos = ciclos;
	}
	
}
