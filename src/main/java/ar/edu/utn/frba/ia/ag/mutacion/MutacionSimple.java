package main.java.ar.edu.utn.frba.ia.ag.mutacion;

public class MutacionSimple extends Mutacion {
	
	private double probabilidadConstante;
	
	public MutacionSimple(double probabilidadConstante) {
		this.probabilidadConstante = probabilidadConstante;
	}
	
	@Override
	protected double probabilidadDeMutacion() {
		return probabilidadConstante;
	}
	
}
