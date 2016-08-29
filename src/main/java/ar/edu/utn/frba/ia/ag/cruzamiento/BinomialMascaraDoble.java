package main.java.ar.edu.utn.frba.ia.ag.cruzamiento;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.UTgeNesUtils;

public class BinomialMascaraDoble extends Cruzamiento {
	
	protected static final String MASCARA_DEFAULT = "MASCARA_DEFAULT";
	
	String mascaraA;
	String mascaraB;
	
	protected Boolean mascarasInvalidas(String mascaraA, String mascaraB) {
		
		return mascaraA != null && mascaraB != null
				&& !mascaraA.isEmpty() && !mascaraB.isEmpty()
				&& mascaraA.length() != mascaraB.length()
				&& mascaraA.replaceAll(Cruzamiento.X,"").replaceAll(Cruzamiento.Y, "").length() > 0
				&& mascaraB.replaceAll(Cruzamiento.X,"").replaceAll(Cruzamiento.Y, "").length() > 0;
	}
	
	public BinomialMascaraDoble(String mascaraA, String mascaraB) {
		
		// Valido las mascaras
		if (mascarasInvalidas(mascaraA, mascaraB)) {
			
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("Máscara erronea. Usando máscara default[(XY)*] y su complemento [(YX)*]");
			
			mascaraA = MASCARA_DEFAULT;
			mascaraB = (new StringBuffer(MASCARA_DEFAULT).reverse().toString());
		}
		
		this.mascaraA = mascaraA;
		this.mascaraB = mascaraB;
	}
	
	@Override
	protected void cruzar(Individuo padreA, Individuo padreB) {
		
		if (MASCARA_DEFAULT.equals(this.mascaraA)) {
			
			this.mascaraA = "";
			this.mascaraB = "";
			
			for (int i = 0; i < padreA.getClass().getDeclaredFields().length; i++) {
				if (i % 2 == 0) {
					this.mascaraA += Cruzamiento.X;
					this.mascaraB += Cruzamiento.Y;
				}
				else {
					this.mascaraA += Cruzamiento.Y;
					this.mascaraB += Cruzamiento.X;
				}
			}
		}
		
		// Controlo si la cantidad de elementos de la máscara es
		// distinta a la cantidad de atributos de los individuos,alidaciones
		if (!(padreA.getClass().getDeclaredFields().length == this.mascaraA.length()) ||
			!(padreA.getClass().getDeclaredFields().length == this.mascaraB.length())) {
			
			throw new RuntimeException("Mascara erronea");
		}
		
		Method getter = null;
		Method setter = null;
		
		for (int i = 0; i < padreA.getClass().getDeclaredFields().length; i++) {
			
			Field field = padreA.getClass().getDeclaredFields()[i];
			
			getter = UTgeNesUtils.armarGetter(padreA, field);
			setter = UTgeNesUtils.armarSetter(padreA, field);
			
			try {
				
				Object valorGenA = getter.invoke(padreA);
				Object valorGenB = getter.invoke(padreB);
				
				setter.invoke(padreA, (this.mascaraA.charAt(i) == Cruzamiento.X.toCharArray()[0]) ? valorGenA : valorGenB);
				setter.invoke(padreB, (this.mascaraB.charAt(i) == Cruzamiento.X.toCharArray()[0]) ? valorGenA : valorGenB);
			}
			
			catch (Exception e) {
				Logger.getLogger(
					Logger.GLOBAL_LOGGER_NAME).severe(
						"Fallo intentando acceder al atributo '"
						+ field + "' de: " + padreA.toString()
						+ " cruzado con " + padreB.toString()
						+ " // CAUSA: " + e);
			}
		}
	}
}
