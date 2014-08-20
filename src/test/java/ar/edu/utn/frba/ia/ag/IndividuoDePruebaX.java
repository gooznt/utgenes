package test.java.ar.edu.utn.frba.ia.ag;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class IndividuoDePruebaX extends Individuo {
	
	private Integer x;
	
	public double aptitud() {
		
		if (x > 10) {
			return 0;
		}
		
		return x;
		
	}
	
	@Override
	public Individuo generarRandom() {
		
		IndividuoDePruebaX ind = new IndividuoDePruebaX();
		
		ind.setX((int)(Math.random() * 12));
		
		return ind;
	}
	
	@Override
	public String toString() {
		return "X= " + this.x + " // " + this.aptitud();
	}
	
	public Integer getX() {
		return x;
	}
	
	public void setX(Integer x) {
		this.x = x;
	}
	
}
