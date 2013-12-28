package main.java.ar.edu.utn.frba.ia.ag.cruzamiento;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class BinomialAzar extends Cruzamiento {
	
	BinomialMascaraDoble cruzamientoAuxiliarMascara;
	
	@Override
	protected void cruzar(Individuo padreA, Individuo padreB) {
		this.getCruzamientoAuxiliar(padreA).cruzar(padreA, padreB);
	}
	
	private BinomialMascaraDoble getCruzamientoAuxiliar(Individuo individuo) {
		
		if (this.cruzamientoAuxiliarMascara == null) {
			
			StringBuffer mascaraA = new StringBuffer();
			StringBuffer mascaraB = new StringBuffer();
			
			for (int i = 0; i < individuo.getClass().getDeclaredFields().length; i++) {
				
				if (Math.random() <= 0.5) {
					mascaraA.append(Cruzamiento.X);
				}
				else {
					mascaraA.append(Cruzamiento.Y);
				}
				
				if (Math.random() <= 0.5) {
					mascaraB.append(Cruzamiento.X);
				}
				else {
					mascaraB.append(Cruzamiento.Y);
				}
			}
			
			this.cruzamientoAuxiliarMascara = new BinomialMascaraDoble(mascaraA.toString(), mascaraB.toString());
		}
		
		return this.cruzamientoAuxiliarMascara;
	}
}
