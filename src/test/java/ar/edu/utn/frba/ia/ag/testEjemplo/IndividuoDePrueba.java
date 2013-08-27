package test.java.ar.edu.utn.frba.ia.ag.testEjemplo;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class IndividuoDePrueba extends Individuo {
	
	private Integer x;
	
	public double aptitud() {
		
		if (x > 10) {
			return 0;
		}
		
		return x;
		
	}
	
	@Override
	public Individuo generarRandom() {
		
		IndividuoDePrueba ind = new IndividuoDePrueba();
		
		ind.setX((int)(Math.random() * 12));
//		ind.setX(3);
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
