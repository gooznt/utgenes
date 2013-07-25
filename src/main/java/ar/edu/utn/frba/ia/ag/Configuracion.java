package main.java.ar.edu.utn.frba.ia.ag;

import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.Cruzamiento;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.Mutacion;
import main.java.ar.edu.utn.frba.ia.ag.paro.CriterioDeParo;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.MetodoDeSeleccion;

public abstract class Configuracion {
	
	protected CriterioDeParo criterioDeParo;
	protected boolean mantenerTamanoPoblacion;
	protected int poblacionInicial;
	protected int cantSeleccion; // solo es necesario si mantenerTamanoPoblacion es FALSE
	protected MetodoDeSeleccion metodoDeSeleccion;
	protected Cruzamiento cruzamiento;
	protected Mutacion mutacion;
	
	Configuracion(CriterioDeParo criterioDeParo,
					boolean mantenerTamanoPoblacion,
					int poblacionInicial,
					int cantSeleccion,
					MetodoDeSeleccion metodoDeSeleccion,
					Cruzamiento cruzamiento,
					Mutacion mutacion) {
		
		this.criterioDeParo = criterioDeParo;
		this.mantenerTamanoPoblacion = mantenerTamanoPoblacion;
		this.poblacionInicial = poblacionInicial;
		this.cantSeleccion = cantSeleccion; // solo es necesario si mantenerTamanoPoblacion es FALSE
		this.metodoDeSeleccion = metodoDeSeleccion;
		this.cruzamiento = cruzamiento;
		this.mutacion = mutacion;
		
	}
	
	public void setCriterioDeParo(CriterioDeParo criterioDeParo) {
		this.criterioDeParo = criterioDeParo;
	}

	public void setMantenerTamanoPoblacion(boolean mantenerTamanoPoblacion) {
		this.mantenerTamanoPoblacion = mantenerTamanoPoblacion;
	}

	public void setPoblacionInicial(int poblacionInicial) {
		this.poblacionInicial = poblacionInicial;
	}

	public void setCantSeleccion(int cantSeleccion) {
		this.cantSeleccion = cantSeleccion;
	}

	public void setMetodoDeSeleccion(MetodoDeSeleccion metodoDeSeleccion) {
		this.metodoDeSeleccion = metodoDeSeleccion;
	}

	public void setCruzamiento(Cruzamiento cruzamiento) {
		this.cruzamiento = cruzamiento;
	}

	public void setMutacion(Mutacion mutacion) {
		this.mutacion = mutacion;
	}

	public CriterioDeParo getCriterioDeParo() {
		return criterioDeParo;
	}
	
	public int getPoblacionInicial() {
		return poblacionInicial;
	}
	
	public int getCantSeleccion() {
		return cantSeleccion;
	}
	
	public boolean getMantenerTamanoPoblacion() {
		return mantenerTamanoPoblacion;
	}

	public MetodoDeSeleccion getMetodoDeSeleccion() {
		return metodoDeSeleccion;
	}

	public Cruzamiento getCruzamiento() {
		return cruzamiento;
	}

	public Mutacion getMutacion() {
		return mutacion;
	}
	
}
