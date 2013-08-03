package main.java.ar.edu.utn.frba.ia.ag;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class UTgeNesUtils {
	
	public static Method armarSetter(Individuo individuo, Field field) {
		
		try {
			
			return individuo.getClass().getMethod("set" + armarAtributoPascalCase(field), field.getType());
			
		} catch (SecurityException e) {
			System.out.println("ERROR en reflection 1");
		} catch (NoSuchMethodException e) {
			System.out.println("ERROR en reflection 2");
		}
		
		return null;
	}
	
	public static Method armarGetter(Individuo individuo, Field field) {
		
		try {
			
			return individuo.getClass().getMethod("get" + armarAtributoPascalCase(field));
			
		} catch (SecurityException e) {
			System.out.println("ERROR en reflection 1");
		} catch (NoSuchMethodException e) {
			System.out.println("ERROR en reflection 2");
		}
		return null;
	}
	
	private static String armarAtributoPascalCase(Field field) {
		return field.getName().toUpperCase().charAt(0) + field.getName().substring(1);
	}
	
}
