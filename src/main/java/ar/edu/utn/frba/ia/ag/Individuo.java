package main.java.ar.edu.utn.frba.ia.ag;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public abstract class Individuo implements Comparable<Individuo>, Cloneable {
	
	public abstract double aptitud();
	
	/**
	 * TODO documentar que si nadie me define el random tomo varias desiciones para generar los atributos:
	 * - Strings alfa-numerico de 10 caracteres
	 * - Numeros al azar entre [0..1000) entero o decimal segun corresponda
	 * - Booleanos de valores equiprobables 
	 */
	public Individuo generarRandom() {
		
		Individuo nuevoIndividuo = null;
		
		try {
			nuevoIndividuo = this.getClass().newInstance();
		} catch (Exception e) {
			Logger.getLogger(
				Logger.GLOBAL_LOGGER_NAME).severe(
					"No se puede crear una instancia de "
					+ this.getClass().getName()
					+ ". Probablemente no tenga un constructor vacio."
					+ " // CAUSA: " + e);
		}
		
		for (Field atributo : this.getClass().getDeclaredFields()) {
			
			try {
				Class<?> clazz = UTgeNesUtils.armarGetter(nuevoIndividuo, atributo).getReturnType();
				
				if (String.class.isAssignableFrom(clazz)) {
					UTgeNesUtils.armarSetter(nuevoIndividuo, atributo).invoke(nuevoIndividuo, UTgeNesUtils.armarRandomString(10));
				}
				else {
					if (Number.class.isAssignableFrom(clazz)) {
						UTgeNesUtils.armarSetter(nuevoIndividuo, atributo).invoke(nuevoIndividuo, Math.random() * 1000);
					}
					else {
						if (Boolean.class.isAssignableFrom(clazz)) {
							UTgeNesUtils.armarSetter(nuevoIndividuo, atributo).invoke(nuevoIndividuo, Math.random() < 0.5);
						}
					}
				}
			} catch (Exception e) {
				Logger.getLogger(
					Logger.GLOBAL_LOGGER_NAME).severe(
						"Fallo Generando atributo random "
						+ atributo.getName()
						+ " // Causa: " + e);
			}
		}
		
		return nuevoIndividuo;
		
	}
	
	/**
	 * Crea un individuo y le settea los atributos de *this*
	 */
	@Override
	public Individuo clone() {
		
		Individuo nuevoIndividuo = null;
		
		try {
			nuevoIndividuo = this.getClass().newInstance();
		} catch (Exception e) {
			Logger.getLogger(
				Logger.GLOBAL_LOGGER_NAME).severe(
					"No se puede crear una instancia de "
					+ this.getClass().getName()
					+ ". Probablemente no tenga un constructor vacio."
					+ " // CAUSA: " + e);
		}
		
		for (Field atributo : this.getClass().getDeclaredFields()) {
			
			try {
				UTgeNesUtils.armarSetter(nuevoIndividuo, atributo).invoke(nuevoIndividuo, UTgeNesUtils.armarGetter(this, atributo).invoke(this));
			} catch (Exception e) {
				Logger.getLogger(
					Logger.GLOBAL_LOGGER_NAME).severe(
						"Fallo Clonando atributo "
						+ atributo.getName()
						+ " // Causa: " + e);
			}
		}
		
		return nuevoIndividuo;
		
	}
	
	public boolean esMasAptoQue(Individuo otroIndividuo) {
		return this.aptitud() > otroIndividuo.aptitud();
	}
	
	@Override
	public int compareTo(Individuo otroIndividuo) {
		if (this.esMasAptoQue(otroIndividuo)) return -1;
		else if (otroIndividuo.esMasAptoQue(this)) return 1;
		else return 0;
	}
	
	/**
	 * En muchos casos, la mutación depende del problema ya que podrían generarse individuos inválidos.
	 * Por esta razón, existe la posibilidad de redefinir la mutación en el individuo.
	 * Este método realiza la mutación de un atriburo aleatorio del individuo.
	 * Por cuestiones prácticas de implementación, la mutación consiste en copiar un atributo desde
	 * individuo de atributos aleatorios en lugar de mutar un bit como lo especifica la teoría.
	 * */
	public void mutar() {
		
		Field atributoAleatorio = (Field)UTgeNesUtils.alguno(this.getClass().getDeclaredFields());
		
//		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info("Mutando atributo: " + atributoAleatorio.getName());
		
		Method getter = UTgeNesUtils.armarGetter(this, atributoAleatorio);
		Method setter = UTgeNesUtils.armarSetter(this, atributoAleatorio);
		
		try {
			
			Individuo individuoRandom = this.generarRandom(); // genero uno nuevo individuo random sólo para robarle el atributo que necesito "mutado"
			
			setter.invoke(this, getter.invoke(individuoRandom)); // reemplazo el atributo de mi individuo por el atributo de mi individuo random
		}
		catch (Exception e) {
			Logger.getLogger(
				Logger.GLOBAL_LOGGER_NAME).severe(
					"Fallo intentando acceder al atributo '"
					+ atributoAleatorio
					+ "' del Idividuo: "
					+ this.toString()
					+ "// CAUSA: " + e);
		}
		
		return;
	}
	
    @Override
    public String toString() {
        
        String genes = new String();
        
        for (Field field : this.getClass().getDeclaredFields()){
            
            Method getter = UTgeNesUtils.armarGetter(this,field);
            
            try {
            	genes += (field.getName() + "= " + getter.invoke(this) + " ");
            }
            catch (Exception e) {
				Logger.getLogger(
					Logger.GLOBAL_LOGGER_NAME).severe(
						"Fallo intentando acceder al atributo '"
						+ field
						+ "' del Idividuo"
						+ "// CAUSA: " + e);
            }
        }
        
        return "Aptitud = " + this.aptitud() + " || Genes: " + genes;
    }
	
}
