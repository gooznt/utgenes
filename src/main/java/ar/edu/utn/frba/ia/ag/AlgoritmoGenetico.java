package main.java.ar.edu.utn.frba.ia.ag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlgoritmoGenetico {
	
	private Configuracion configuracion;
	private List<Individuo> individuos;
	private Class<? extends Individuo> individuoClass;
	private List<Double> aptitudesPromedio = new ArrayList<Double>();
	private List<Individuo> individuosDestacados = new ArrayList<Individuo>();
	
	protected void agregarIndividuo(Individuo individuo) {
		
		if (this.individuos == null) {
			this.individuos = new ArrayList<Individuo>();
		}
		
		this.individuos.add(individuo);
	}
	
	public AlgoritmoGenetico(Configuracion configuracion, Class<? extends Individuo> individuoClass) {
		
		this.configuracion = (configuracion != null ? configuracion : new ConfiguracionDefault());
		this.individuoClass = individuoClass;
	}
	
	protected void generarPoblacionInicial(Class<? extends Individuo> individuoClass) {
		
		for (int i = 0; i < this.configuracion.getPoblacionInicial(); i++) {
			try {
				this.agregarIndividuo(individuoClass.newInstance().generarRandom());
			} catch (Exception e) {
				Logger.getLogger(
					Logger.GLOBAL_LOGGER_NAME).severe(
						"No se puede crear una instancia de "
						+ individuoClass.getName()
						+ ". Probablemente no tenga un constructor vacio."
						+ " // CAUSA: " + e);
			}
		}
	}
	
	public Individuo ejecutar() {
		
		this.generarPoblacionInicial(individuoClass);
		
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.FINE, "Población inicial");
		
		for (Individuo individuo : this.individuos) {
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.FINE, individuo.toString());
		}
		
		Integer iteracion = new Integer(0);
		
		while (!this.configuracion.getCriterioDeParo().parar(this.individuos)) {
			
			this.seleccion();
			
			this.cruzamiento();
			
			this.mutacion();
			
			this.estadisticas(iteracion);
			
			iteracion++;
		}
		
		Collections.sort(this.individuos);
		
		this.loggearEstado();
		
		return this.individuos.get(0);
	}
	
	private void estadisticas(Integer iteracion) {
		
		Double totalAptitudes = new Double(0);
		Individuo individuoDestacado = this.individuos.get(0);
		
		for (int i = 0; i < this.individuos.size(); i++) {
			
			Individuo individuo = this.individuos.get(i);
			
			totalAptitudes += individuo.aptitud();
			
			if (individuo.aptitud() > individuoDestacado.aptitud()) {
				individuoDestacado = individuo;
			}
		}
		
		this.aptitudesPromedio.add(totalAptitudes / this.individuos.size());
		this.individuosDestacados.add(individuoDestacado);
	}
	
	private void seleccion() {
		
		if(this.configuracion.getMantenerTamanoPoblacion()){
			this.configuracion.getMetodoDeSeleccion().seleccionar(this.individuos, this.configuracion.getPoblacionInicial());
		}
		else {
			this.configuracion.getMetodoDeSeleccion().seleccionar(this.individuos, this.configuracion.getCantSeleccion());
		}
	}
	
	private void cruzamiento() {
		this.configuracion.getCruzamiento().cruzarIndividuos(this.individuos);
	}
	
	private void mutacion() {
		this.configuracion.getMutacion().mutar(this.individuos);
	}
	
	private void loggearEstado() {
		
		for (int i = 0; i < individuosDestacados.size(); i++) {
			
			Individuo individuo = individuosDestacados.get(i);
			Double aptitudPromedio = aptitudesPromedio.get(i);
			
			Logger.getLogger(
					Logger.GLOBAL_LOGGER_NAME).log(
							Level.SEVERE,
							"Promedio: "
									+ aptitudPromedio
									+ " // Mejor Individuo "
									+ individuo.toString());
		}
		
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info("Individuo mas Apto: " + this.individuos.get(0).toString());
		
		Collections.sort(individuosDestacados);
		
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info("Individuo Campeon: " + individuosDestacados.get(0));
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info("Me falta: imprimir logs para estadisticas, Ruleta y Control sobre numero esperado, varias tecnicas de mutacion y cómo mutar");
	}
}
