package main.java.ar.edu.utn.frba.ia.ag.cruzamiento;

public class CruzamientoBinomialMascaraComplemento extends CruzamientoBinomialMascaraDoble {
	
	private static final String stringAux = "$";

	public CruzamientoBinomialMascaraComplemento(String mascaraA) {
		
		// Invoco al contrcuctor de CruzamientoBinomialMascaraDoble con mascaraA y su complemento
		super(mascaraA, mascaraA.replace(X, stringAux).replace(Y, X).replace(stringAux, Y));
		
		// luego, todo continua funcionando como si tuviese inicialmente 2 mascaras
	}
	
}
