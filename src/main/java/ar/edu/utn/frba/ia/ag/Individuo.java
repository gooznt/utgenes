package main.java.ar.edu.utn.frba.ia.ag;

public abstract class Individuo implements Comparable<Individuo> {
	
	public abstract double aptitud();
	
	public boolean esMasAptoQue(Individuo otroIndividuo) {
		return this.aptitud() > otroIndividuo.aptitud();
	}
	
	@Override
	public int compareTo(Individuo otroIndividuo) {
		if (this.esMasAptoQue(otroIndividuo)) return -1;
		else if (otroIndividuo.esMasAptoQue(this)) return 1;
		else return 0;
	}

	public abstract Individuo generarRandom();
	
}
