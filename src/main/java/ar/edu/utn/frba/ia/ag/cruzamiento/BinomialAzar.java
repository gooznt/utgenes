package main.java.ar.edu.utn.frba.ia.ag.cruzamiento;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class BinomialAzar extends Cruzamiento {
	
	@Override
	protected void cruzar(Individuo padreA, Individuo padreB) {
		
		Method getter = null;
		Method setter = null;
		
		for (Field field : padreA.getClass().getDeclaredFields()) {
			
			getter = armarGetter(padreA, field);
			setter = armarSetter(padreA, field);
			
			try {
				
				Object auxA = getter.invoke(padreA);
				Object auxB = getter.invoke(padreB);
				
				if (Math.random() <= 0.5) {
					setter.invoke(padreA, auxA);
				}
				else {
					setter.invoke(padreA, auxB);
				}
				
				if (Math.random() <= 0.5) {
					setter.invoke(padreB, auxB);
				}
				else {
					setter.invoke(padreB, auxA);
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
		}
	}
}
