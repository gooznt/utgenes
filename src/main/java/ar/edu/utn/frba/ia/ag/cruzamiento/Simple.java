package main.java.ar.edu.utn.frba.ia.ag.cruzamiento;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class Simple extends Cruzamiento {
	
	BinomialMascaraComplemento cruzamientoAuxiliarMascara;
	
	@Override
	protected void cruzar(Individuo padreA, Individuo padreB) {
		this.getCruzamientoAuxiliar(padreA).cruzar(padreA, padreB);
	}
	
	private BinomialMascaraComplemento getCruzamientoAuxiliar(Individuo individuo) {
		
		if (this.cruzamientoAuxiliarMascara == null) {
			
			StringBuffer mascara = new StringBuffer();
			
			int cantX = (int)(Math.random() * individuo.getClass().getDeclaredFields().length);
			
			for (int i = 0; i < cantX; i++) {
				mascara.append(Cruzamiento.X);
			}
			
			for (int i = mascara.length(); i < individuo.getClass().getDeclaredFields().length; i++) {
				mascara.append(Cruzamiento.Y);
			}
			
			this.cruzamientoAuxiliarMascara = new BinomialMascaraComplemento(mascara.toString());
			
		}
		
		return this.cruzamientoAuxiliarMascara;
	}
	
}
