package main.java.ar.edu.utn.frba.ia.ag.ejemplos.optimizacion;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class Combinaciones extends Individuo {
	
	/**
	 * Función objetivo
	 * 
	 * zMax = 15H + 13S + 11U
	 * 
	 * Restricciones
	 * 
	 * 3H + 2S + 1,5U <= 500
	 * 2H + 2,5S + 1,5U <= 390
	 * 0,5H + 1S + 0,5U <= 215
	 * 2H + 0,5S + 1U <= 145
	 * 
	 * */
	
	private Double h;
	private Double s;
	private Double u;
	
	public Double getH() {
		return h;
	}

	public void setH(Double h) {
		this.h = h;
	}

	public Double getS() {
		return s;
	}

	public void setS(Double s) {
		this.s = s;
	}

	public Double getU() {
		return u;
	}

	public void setU(Double u) {
		this.u = u;
	}
	
	public double aptitud() {
		
		if (h < 0
			|| s < 0
			|| u < 0
			|| 3*h + 2*s + 1.5*u > 500
			|| 2*h + 2.5*s + 1.5*u > 390
			|| 0.5*h + s + 0.5*u > 215
			|| 2*h + 0.5*s + u > 145) {
			return 0;
		}
		
		return 15 * h + 13 * s + 11 * u;
		
	}
	
	@Override
	public Individuo generarRandom() {
		
		Combinaciones combinaciones = new Combinaciones();
		
		combinaciones.setH(Math.random() * 100);
		combinaciones.setS(Math.random() * 100);
		combinaciones.setU(Math.random() * 100);
		
		return combinaciones;
	}
	
	@Override
	public String toString() {
		return "H= " + h + " S= " + s + " U= " + u + " = " + this.aptitud();
	}
}
