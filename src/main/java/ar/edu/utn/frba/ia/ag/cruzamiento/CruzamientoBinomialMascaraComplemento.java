package main.java.ar.edu.utn.frba.ia.ag.cruzamiento;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class CruzamientoBinomialMascaraComplemento extends Cruzamiento {
	
	private static final String stringAux = "$";
	
	CruzamientoBinomialMascaraDoble cruzamientoAuxiliarMascara;
	
	@Override
	protected void cruzar(Individuo padreA, Individuo padreB) {
		
		this.getCruzamientoAuxiliar(padreA).cruzar(padreA, padreB);
		
	}
	
	public CruzamientoBinomialMascaraComplemento(String mascara) {
		
		// Invoco al constrcuctor de CruzamientoBinomialMascaraDoble con mascaraA y su complemento
		
		String mascaraComplemento = mascara.replace(Cruzamiento.X, stringAux).replace(Cruzamiento.Y, Cruzamiento.X).replace(stringAux, Cruzamiento.Y);
		
		this.cruzamientoAuxiliarMascara = new CruzamientoBinomialMascaraDoble(mascara, mascaraComplemento);
		
		// luego, todo continua funcionando como si tuviese inicialmente 2 mascaras
	}
	
	private CruzamientoBinomialMascaraDoble getCruzamientoAuxiliar(Individuo individuo) {
		return this.cruzamientoAuxiliarMascara;
	}
}
