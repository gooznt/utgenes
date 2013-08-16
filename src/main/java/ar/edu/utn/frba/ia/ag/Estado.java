package main.java.ar.edu.utn.frba.ia.ag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Estado {
	
	private List<Double> aptitudesPromedio;
	private List<Double> totalAptitudes;
	private List<Individuo> mejoresIndividuos;
	private List<Individuo> peoresIndividuos;
	private int ciclos = 0;
	private int cantMutaciones = 0;
	
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
	public void agregarMejorIndividuo(Individuo mejorIndividuo) {
		
		if (this.mejoresIndividuos == null) {
			this.mejoresIndividuos = new ArrayList<Individuo>();
		}
		
		this.mejoresIndividuos.add(mejorIndividuo);
	}
	
	public void agregarPeorIndividuo(Individuo peorIndividuo) {
		
		if (this.peoresIndividuos == null) {
			this.peoresIndividuos = new ArrayList<Individuo>();
		}
		
		this.peoresIndividuos.add(peorIndividuo);
	}
	
	public Individuo getMejorIndividuo() {
		
		List<Individuo> mejoresIndividuos = this.mejoresIndividuos; // para no romer el orden original
		
		Collections.sort(this.mejoresIndividuos);
		
		return mejoresIndividuos.get(0);
	}
	
	public Individuo getPeorIndividuo() {
		
		List<Individuo> peoresIndividuos = this.peoresIndividuos; // para no romer el orden original
		
		Collections.sort(this.peoresIndividuos);
		
		return peoresIndividuos.get(peoresIndividuos.size() - 1);
	}
	
	public List<Individuo> getMejoresIndividuos() {
		return mejoresIndividuos;
	}

	public List<Individuo> getPeoresIndividuos() {
		return peoresIndividuos;
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

	public void sumarMutacion() {
		this.cantMutaciones  ++;
	}
	
	public int getCantMutaciones() {
		return this.cantMutaciones;
	}

}
