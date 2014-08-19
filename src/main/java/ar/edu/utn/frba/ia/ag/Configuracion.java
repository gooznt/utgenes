package main.java.ar.edu.utn.frba.ia.ag;

import java.util.logging.Level;
import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.Cruzamiento;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.Mutacion;
import main.java.ar.edu.utn.frba.ia.ag.paro.CriterioDeParo;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Seleccion;

public abstract class Configuracion {
	
	protected CriterioDeParo criterioDeParo;
	protected int poblacionInicial;
	protected Seleccion metodoDeSeleccion;
	protected Cruzamiento cruzamiento;
	protected Mutacion mutacion;
	
	protected Configuracion(CriterioDeParo criterioDeParo,
					int poblacionInicial,
					Seleccion metodoDeSeleccion,
					Cruzamiento cruzamiento,
					Mutacion mutacion) {
		
		this.criterioDeParo = criterioDeParo;
		this.poblacionInicial = poblacionInicial;
		this.metodoDeSeleccion = metodoDeSeleccion;
		this.cruzamiento = cruzamiento;
		this.mutacion = mutacion;
		this.setLogLevel();
		
	}
	
	public void setLogLevel() {
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.FINE);
	}
	
	public void setCriterioDeParo(CriterioDeParo criterioDeParo) {
		this.criterioDeParo = criterioDeParo;
	}

	public void setPoblacionInicial(int poblacionInicial) {
		this.poblacionInicial = poblacionInicial;
	}

	public void setMetodoDeSeleccion(Seleccion metodoDeSeleccion) {
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
	
	public Seleccion getMetodoDeSeleccion() {
		return metodoDeSeleccion;
	}

	public Cruzamiento getCruzamiento() {
		return cruzamiento;
	}

	public Mutacion getMutacion() {
		return mutacion;
	}
	
}
