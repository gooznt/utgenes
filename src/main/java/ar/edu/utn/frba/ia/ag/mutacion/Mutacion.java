package main.java.ar.edu.utn.frba.ia.ag.mutacion;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public abstract class Mutacion {
	
	public void mutar(List<Individuo> individuos) {
		
		if (Math.random() <= this.probabilidadDeMutacion()) {
			
			Individuo individuoAleatorio = individuos.get((int)(Math.random() * individuos.size()));
			
			Field atributoAleatorio = individuoAleatorio.getClass().getDeclaredFields()[(int)(Math.random() * individuoAleatorio.getClass().getDeclaredFields().length)];
			
			System.out.println("MUTAAAAAAAAAA1 el atributo: " + atributoAleatorio.getName());
			System.out.println(individuoAleatorio.toString());
			
			Method getter = null;
			Method setter = null;
			
			String atributoPascalCase = atributoAleatorio.getName().toUpperCase().charAt(0) + atributoAleatorio.getName().substring(1); // NombreDelAtributo con la primera legra Mayúscula
			
			try {
				getter = individuoAleatorio.getClass().getMethod("get" + atributoPascalCase);
				setter = individuoAleatorio.getClass().getMethod("set" + atributoPascalCase, atributoAleatorio.getType());
			} catch (SecurityException e) {
				System.out.println("ERROR en reflection 6");
			} catch (NoSuchMethodException e) {
				System.out.println("ERROR en reflection 7");
			}
			
			try {
				System.out.println("Falta definir la mutacion");
//					capaz puedo hacer algo como:
//					if tengo un string hago x
//					if tengo un numero hago y
				
				Object nuevoValor = (int)(Math.random() * 1000);
				
				// hay que hacerle un "| 2" o algo asi al valor primitivo
				
				setter.invoke(individuoAleatorio, nuevoValor); // getter.invoke(individuoAleatorio) | 2 ó & 2
			}
			catch (IllegalArgumentException e) {
				System.out.println("ERROR en reflection 8");
			}
			catch (IllegalAccessException e) {
				System.out.println("ERROR en reflection 9");
			}
			catch (InvocationTargetException e) {
				System.out.println("ERROR en reflection 10");
			}
			
			System.out.println("MUTAAAAAAAAAA2");
			System.out.println(individuoAleatorio.toString());
		}
	}

	protected abstract double probabilidadDeMutacion();
	
}
