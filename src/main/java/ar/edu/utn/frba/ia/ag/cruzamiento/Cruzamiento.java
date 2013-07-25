package main.java.ar.edu.utn.frba.ia.ag.cruzamiento;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public abstract class Cruzamiento {
	
	protected static final String X = "X";
	protected static final String Y = "Y";
	
	protected abstract void cruzar(Individuo padreA, Individuo padreB);
	
	public List<Individuo> cruzasIndividuos(List<Individuo> individuos) {
		
		List<Individuo> nuevos = new ArrayList<Individuo>();
		
		for (int i = 0; i < individuos.size() ; i++) {
			cruzar(individuos.get(i), individuos.get(individuos.size() - i - 1));
		}
		
		return nuevos;
	}
	
	protected Method armarSetter(Individuo individuo, Field field) {
		
		Method setter = null;
		
		try {
			setter = individuo.getClass().getMethod("set" + armarAtributoPascalCase(field), field.getType());
		} catch (SecurityException e) {
			System.out.println("ERROR en reflection 1");
		} catch (NoSuchMethodException e) {
			System.out.println("ERROR en reflection 2");
		}
		
		return setter;
	}
	
	protected Method armarGetter(Individuo individuo, Field field) {
		
		Method getter = null;
		
		try {
			getter = individuo.getClass().getMethod("get" + armarAtributoPascalCase(field));
		} catch (SecurityException e) {
			System.out.println("ERROR en reflection 1");
		} catch (NoSuchMethodException e) {
			System.out.println("ERROR en reflection 2");
		}
		
		return getter;
	}
	
	private String armarAtributoPascalCase(Field field) {
		return field.getName().toUpperCase().charAt(0) + field.getName().substring(1);
	}
	
}
