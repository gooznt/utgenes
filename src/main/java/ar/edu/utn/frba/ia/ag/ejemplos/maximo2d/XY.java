package main.java.ar.edu.utn.frba.ia.ag.ejemplos.maximo2d;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class XY extends Individuo {
	
	private Double x;
	private Double y;
	
	public Double getX() {
		return x;
	}
	
	public void setX(Double x) {
		this.x = x;
	}
	
	public Double getY() {
		return y;
	}
	
	public void setY(Double y) {
		this.y = y;
	}
	
	public double aptitud() {
		
		if (this.x < 0 || this.x > 15
			|| this.y < 0 || this.y > 15) {
			return 0;
		}
		
		return Math.abs((this.x - 5) + (this.y - 3) / (2 + Math.sin(this.x + this.y)));
	}
	
	@Override
	public Individuo generarRandom() {
		
		XY x = new XY();
		
		x.setX(Math.random() * 15);
		x.setY(Math.random() * 15);
		
		return x;
	}
	
	@Override
	public String toString() {
		return "x," + x + "y " + y + " / f(x,y) = " + this.aptitud();
	}
}
