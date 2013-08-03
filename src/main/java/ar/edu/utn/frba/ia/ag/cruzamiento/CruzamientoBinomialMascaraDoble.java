package main.java.ar.edu.utn.frba.ia.ag.cruzamiento;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.UTgeNesUtils;

public class CruzamientoBinomialMascaraDoble extends Cruzamiento {
	
	protected static final String MASCARA_DEFAULT = "MASCARA_DEFAULT";
	
	String mascaraA;
	String mascaraB;
	
	protected Boolean mascarasInvalidas(String mascaraA, String mascaraB) {
		
		return mascaraA != null && mascaraB != null
				&& !mascaraA.isEmpty() && !mascaraB.isEmpty()
				&& mascaraA.length() != mascaraB.length()
				&& mascaraA.replaceAll(X,"").replaceAll(Y, "").length() > 0
				&& mascaraB.replaceAll(X,"").replaceAll(Y, "").length() > 0;
	}
	
	public CruzamientoBinomialMascaraDoble(String mascaraA, String mascaraB) {
		
		// Algunas validaciones
		if (mascarasInvalidas(mascaraA, mascaraB)) {
			
			System.out.println("Máscara erronea. Usando máscara default XYXYXYXYXYXYXYXYXYXY");
			
			mascaraA = MASCARA_DEFAULT;
			mascaraB = (new StringBuffer(MASCARA_DEFAULT).reverse().toString());
		}
		
		this.mascaraA = mascaraA;
		this.mascaraB = mascaraB;
	}
	
	@Override
	protected void cruzar(Individuo padreA, Individuo padreB) {
		
		// Controlo si la cantidad de elementos de la máscara es
		// distinta a la cantidad de atributos de los individuos,alidaciones
		if ((!(padreA.getClass().getDeclaredFields().length == this.mascaraA.length()) ||
				!(padreA.getClass().getDeclaredFields().length == this.mascaraB.length())) &&
			!this.mascaraA.equals(MASCARA_DEFAULT) && !this.mascaraA.equals(MASCARA_DEFAULT)) {
			
			throw new RuntimeException("Mascara erronea");
		}
		
		Method getter = null;
		Method setter = null;
		
		int i = 0;
		
		for (Field field : padreA.getClass().getDeclaredFields()) {
			
			getter = UTgeNesUtils.armarGetter(padreA, field);
			setter = UTgeNesUtils.armarSetter(padreA, field);
			
			try {
				
				if (this.mascaraA.equals(MASCARA_DEFAULT)) {
					
					if (i % 2 > 0) {
						
						Object aux = getter.invoke(padreA);
						
						setter.invoke(padreA, getter.invoke(padreB));
						setter.invoke(padreB, aux);
					}
				}
				else {
					
					Object auxA = mascaraA.charAt(i) == X.toCharArray()[0] ? getter.invoke(padreA) : getter.invoke(padreB);
					Object auxB = mascaraB.charAt(i) == X.toCharArray()[0] ? getter.invoke(padreA) : getter.invoke(padreB);
					
					setter.invoke(padreA, auxA);
					setter.invoke(padreB, auxB);
				}
			}
			catch (IllegalArgumentException e) {
				System.out.println("ERROR en reflection 3");
			}
			catch (IllegalAccessException e) {
				System.out.println("ERROR en reflection 4");
			}
			catch (InvocationTargetException e) {
				System.out.println("ERROR en reflection 5");
			}
			
			i++;
		}
	}
}
