package test.java.ar.edu.utn.frba.ia.ag;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class IndividuoDePrueba extends Individuo {
	
	private int prop1;
	private int prop2;
	
//	public IndividuoDePrueba(int prop1, int prop2) {
//		this.setProp1(prop1);
//		this.setProp2(prop2);
//	}
//
	@Override
	public double aptitud() {
		return prop1 + prop2;
	}
	
	public int getProp1() {
		return prop1;
	}
	
	public void setProp1(int prop1) {
		this.prop1 = prop1;
	}
	
	public int getProp2() {
		return prop2;
	}
	
	public void setProp2(int prop2) {
		this.prop2 = prop2;
	}

	public IndividuoDePrueba() {
		this.setProp1((int)(Math.random() * 100));
		this.setProp2((int)(Math.random() * 100));
	}

	public IndividuoDePrueba(int prop1, int prop2) {
		this.setProp1(prop1);
		this.setProp2(prop2);
	}

	@Override
	public Individuo generarRandom() {
		return this.clone();
	}
	
	@Override
	public String toString() {
		return (new Double(aptitud())).toString();
	}
	
}
