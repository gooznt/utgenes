package main.java.ar.edu.utn.frba.ia.ag.ejemplos.monedas;

import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class Monedero extends Individuo {
	
	private Integer monedasDe1;
	private Integer monedasDe5;
	private Integer monedasDe10;
	private Integer monedasDe25;
	private Integer monedasDe50;
	private Integer monedasDe1peso;
	private Integer monedasDe2pesos;
	
	public Integer getMonedasDe5() {
		return monedasDe5;
	}

	public void setMonedasDe5(Integer monedasDe5) {
		this.monedasDe5 = monedasDe5;
	}

	public Integer getMonedasDe10() {
		return monedasDe10;
	}

	public void setMonedasDe10(Integer monedasDe10) {
		this.monedasDe10 = monedasDe10;
	}

	public Integer getMonedasDe25() {
		return monedasDe25;
	}

	public void setMonedasDe25(Integer monedasDe25) {
		this.monedasDe25 = monedasDe25;
	}

	public Integer getMonedasDe50() {
		return monedasDe50;
	}

	public void setMonedasDe50(Integer monedasDe50) {
		this.monedasDe50 = monedasDe50;
	}

	public Integer getMonedasDe1peso() {
		return monedasDe1peso;
	}

	public void setMonedasDe1peso(Integer monedasDe1peso) {
		this.monedasDe1peso = monedasDe1peso;
	}

	public Integer getMonedasDe2pesos() {
		return monedasDe2pesos;
	}

	public void setMonedasDe2pesos(Integer monedasDe2pesos) {
		this.monedasDe2pesos = monedasDe2pesos;
	}

	public Integer getMonedasDe1() {
		return monedasDe1;
	}
	
	public void setMonedasDe1(Integer monedasDe1) {
		this.monedasDe1 = monedasDe1;
	}
	
	public double aptitud() {
		
		double cantMonedas = monedasDe1 + monedasDe5 + monedasDe10
				+ monedasDe25 + monedasDe50
				+ monedasDe1peso + monedasDe2pesos;
		
		// si no es 742.15 no me sirve, arreglo el resultado para que sea menos apto
		return this.getMonto() != 742.15 ? 999999 : cantMonedas;
	}
	
	@Override
	public boolean esMasAptoQue(Individuo individuo) {
		return this.aptitud() < individuo.aptitud();
	}
	
	@Override
	public Individuo generarRandom() {
		
		double totalDinero = 742.15;
		double tengo = 0;
		
		Monedero monedas = new Monedero();
		
		monedas.setMonedasDe2pesos((int)(Math.random() * ((totalDinero - tengo) / 2)));
		tengo += monedas.getMonedasDe2pesos() * 2;
		
		monedas.setMonedasDe1peso((int)(Math.random() * ((totalDinero - tengo) / 1)));
		tengo += monedas.getMonedasDe1peso() * 1;
		
		monedas.setMonedasDe50((int)(Math.random() * ((totalDinero - tengo) / 0.5)));
		tengo += monedas.getMonedasDe50() * 0.5;
		
		monedas.setMonedasDe25((int)(Math.random() * ((totalDinero - tengo) / 0.25)));
		tengo += monedas.getMonedasDe25() * 0.25;
		
		monedas.setMonedasDe10((int)(Math.random() * ((totalDinero - tengo) / 0.1)));
		tengo += monedas.getMonedasDe10() * 0.1;
		
		monedas.setMonedasDe5((int)(Math.random() * ((totalDinero - tengo) / 0.05)));
		tengo += monedas.getMonedasDe5() * 0.05;
		
		monedas.setMonedasDe1((int)Math.ceil(((totalDinero - tengo) * 100)));
		tengo += monedas.getMonedasDe1() * 0.01;
		
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info("PLATA DEL MONEDERO: " + tengo + "/" + totalDinero);
		
		return monedas;
	}
	
	private double getMonto() {
		return this.getMonedasDe1() * 0.01 + this.getMonedasDe5() * 0.05
				+ this.getMonedasDe10() * 0.1 + this.getMonedasDe25() * 0.25
				+ this.getMonedasDe50() * 0.5 + this.getMonedasDe1peso()
				+ this.getMonedasDe2pesos() * 2;
	}
	
	@Override
	public String toString() {
		
		return this.getMonto() + "(0.01: " + this.getMonedasDe1()
				+ "/ 0.05: " + this.getMonedasDe5()
				+ "/ 0.10:" + this.getMonedasDe10()
				+ "/ 0.25:" + this.getMonedasDe25()
				+ "/ 0.50:" + this.getMonedasDe50()
				+ "/ 1.00:" + this.getMonedasDe1peso()
				+ "/ 2.00:" + this.getMonedasDe2pesos()
				+ ") Apto: " + this.aptitud();
	}
}
