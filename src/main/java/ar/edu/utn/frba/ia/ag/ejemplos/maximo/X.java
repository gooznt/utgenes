package main.java.ar.edu.utn.frba.ia.ag.ejemplos.maximo;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class X extends Individuo {
	
	private Double x;
	
	@Override
	public Individuo generarRandom() {
		
		X x = new X();
		x.setX(Math.random() * 20);
		return x;
	}
	
	@Override
	public double aptitud() {
		
		if (this.x < 0 || this.x > 15) {
			return 0;
		}
		return Math.abs((this.x - 5) / (2 + Math.sin(this.x)));
	}
	
	public Double getX() {
		return x;
	}
	
	public void setX(Double x) {
		this.x = x;
	}
	
	@Override
	public String toString() {
		return "x = " + x + " / f(x) = " + this.aptitud();
	}
}
