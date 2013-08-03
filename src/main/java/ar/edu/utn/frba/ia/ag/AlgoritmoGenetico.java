package main.java.ar.edu.utn.frba.ia.ag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlgoritmoGenetico {
	
	private Configuracion configuracion;
	private List<Individuo> individuos;
	private Class<? extends Individuo> individuoClass;
	
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
				System.err.println("No se puede crear una instancia de " + individuoClass.getName() + ". Probablemente no tenga un constructor vacio.");
			}

		}
	}
	
	public Individuo ejecutar() {
		
		this.generarPoblacionInicial(individuoClass);
		
		while (!this.configuracion.getCriterioDeParo().parar(this.individuos)) {
			
			this.seleccion();
			
			this.cruzamiento();
			
			this.mutacion();
			
		}
		
		Collections.sort(this.individuos);
		
		loggearEstado();
		
		return this.individuos.get(0);
		
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
		
		this.configuracion.getCruzamiento().cruzasIndividuos(this.individuos);
		
	}
	
	private void mutacion() {
		this.configuracion.getMutacion().mutar(this.individuos);
	}
	
	private void loggearEstado() {
		
		double totalAptitud = 0;
		
		for (Individuo individuo: this.individuos) {
			
			totalAptitud += individuo.aptitud();
			
			System.out.println(individuo.toString());
		}
		
		System.out.println("Promedio: " + totalAptitud / this.individuos.size());
		System.out.println("Individuo mas Apto: " + this.individuos.get(0));
		System.err.println("Me falta: imprimir logs para estadisticas, Ruleta y Control sobre numero esperado, varias tecnicas de mutacion y cómo mutar");
		
	}
	
}
