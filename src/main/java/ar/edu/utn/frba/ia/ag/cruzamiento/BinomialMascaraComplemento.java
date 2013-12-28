package main.java.ar.edu.utn.frba.ia.ag.cruzamiento;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class BinomialMascaraComplemento extends Cruzamiento {
	
	private static final String stringAux = "$";
	
	BinomialMascaraDoble cruzamientoAuxiliarMascara;
	
	@Override
	protected void cruzar(Individuo padreA, Individuo padreB) {
		
		this.getCruzamientoAuxiliar(padreA).cruzar(padreA, padreB);
		
	}
	
	public BinomialMascaraComplemento(String mascara) {
		
		// Invoco al constrcuctor de CruzamientoBinomialMascaraDoble con mascaraA y su complemento
		
		String mascaraComplemento = mascara.replace(Cruzamiento.X, stringAux).replace(Cruzamiento.Y, Cruzamiento.X).replace(stringAux, Cruzamiento.Y);
		
		this.cruzamientoAuxiliarMascara = new BinomialMascaraDoble(mascara, mascaraComplemento);
		
		// luego, todo continua funcionando como si tuviese inicialmente 2 mascaras
	}
	
	private BinomialMascaraDoble getCruzamientoAuxiliar(Individuo individuo) {
		return this.cruzamientoAuxiliarMascara;
	}
}
