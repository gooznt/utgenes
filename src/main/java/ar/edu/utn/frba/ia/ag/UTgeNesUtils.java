package main.java.ar.edu.utn.frba.ia.ag;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public abstract class UTgeNesUtils {
	
	public static Method armarSetter(Individuo individuo, Field field) {
		
		try {
			
			return individuo.getClass().getMethod("set" + armarAtributoPascalCase(field), field.getType());
			
		} catch (Exception e) {
			Logger.getLogger(
				Logger.GLOBAL_LOGGER_NAME).severe(
					"No se puede ejecurar el Setter del individuo {0}"
					+ individuo.toString()
					+ " // CAUSA: "
					+ e);
		}
		
		return null;
	}
	
	public static Method armarGetter(Individuo individuo, Field field) {
		
		try {
			
			return individuo.getClass().getMethod("get" + armarAtributoPascalCase(field));
			
		} catch (Exception e) {
			Logger.getLogger(
					Logger.GLOBAL_LOGGER_NAME).severe(
						"No se puede ejecurar el Getter del individuo {0}"
						+ individuo.toString()
						+ " // CAUSA: "
						+ e);
		}
		return null;
	}
	
	private static String armarAtributoPascalCase(Field field) {
		return field.getName().toUpperCase().charAt(0) + field.getName().substring(1);
	}
	
	public static Object alguno(Object[] elementos) {
		
		return elementos[(int)(Math.random() * elementos.length)];
	}
	
	public static String armarRandomString(int length) {
		
		String alfabeto = "abcdefghijklmnopqrstuvwxyz";
		StringBuffer buffer = new StringBuffer("");
		
		for (int i = 0; i < length; i++) {
			double index = Math.random() * alfabeto.length();
			buffer.append(alfabeto.charAt((int) index));
		}
		
		return buffer.toString();
		
	}
	
}
