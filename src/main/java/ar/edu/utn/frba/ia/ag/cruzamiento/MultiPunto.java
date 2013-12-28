package main.java.ar.edu.utn.frba.ia.ag.cruzamiento;

import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class MultiPunto extends Cruzamiento {
	
	List<Integer> puntosDeCorte;
	
	BinomialMascaraComplemento cruzamientoAuxiliarMascara;
	
	public MultiPunto(List<Integer> puntosDeCorte) {
		
		if (puntosDeCorte == null || puntosDeCorte.isEmpty()) {
			throw new RuntimeException("puntosDeCorte inválidos");
		}
		
		this.puntosDeCorte = puntosDeCorte;
	}
	
	@Override
	protected void cruzar(Individuo padreA, Individuo padreB) {
		
		this.getCruzamientoAuxiliar(padreA).cruzar(padreA, padreB);
		
	}
	
	String invertirTemplate(String template) {
		if (template == null || template.isEmpty() || template.equals(Cruzamiento.Y)) {
			return Cruzamiento.X;
		}
		else {
			return Cruzamiento.Y;
		}
	} 
	
	private BinomialMascaraComplemento getCruzamientoAuxiliar(Individuo individuo) {
		
		if (this.cruzamientoAuxiliarMascara == null) {
			
			StringBuffer mascara = new StringBuffer();
			String template = Cruzamiento.Y; // Inicializo en Y para que le primera vez me ponga X
			
			for (Integer puntoDeCorte : this.puntosDeCorte) {
				
				template = invertirTemplate(template);
				
				for (int i = 0; i < puntoDeCorte; i++) {
					mascara.append(template);
				}
			}
			
			// Invierto el template de la mascara para los restantes
			template = invertirTemplate(template);
			
			// Agrego los restantes X o Y a la mascara hasta completar la cantidad de atributos del individuo
			for (int i = mascara.length(); i < individuo.getClass().getDeclaredFields().length; i++) {
				mascara.append(template);
			}
			
			this.cruzamientoAuxiliarMascara = new BinomialMascaraComplemento(mascara.toString());
			
		}
		
		return this.cruzamientoAuxiliarMascara;
	}
	
}
