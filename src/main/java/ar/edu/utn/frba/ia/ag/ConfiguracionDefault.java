package main.java.ar.edu.utn.frba.ia.ag;

import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.Simple;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.MutacionSimple;
import main.java.ar.edu.utn.frba.ia.ag.paro.CantidadDeCiclos;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Torneo;

public class ConfiguracionDefault extends Configuracion {
	
	public ConfiguracionDefault() {
		
		super(new CantidadDeCiclos(99L), // criterio de paro
				999, // cantIndividuosIniciales
				new Torneo(), // seleccion
				new Simple(), // cruzamiento
				new MutacionSimple(0.2)); // mutacion
	}

// Criterio de Paro
//	protected CriterioDeParo criterioDeParo = new CantidadDeVueltas(99L);
//	protected CriterioDeParo CRITERIO_DE_PARO = new AptitudMinima(800);
//	protected CriterioDeParo CRITERIO_DE_PARO = new AptitudMinimaPromedio(1500);
//	protected CriterioDeParo CRITERIO_DE_PARO = new TiempoTranscurrido(0, 0, 40); // numero de segundos
	
// Población
//	protected int poblacionInicial = 999;
//	protected int cantSeleccion = 10;
//	protected boolean mantenerTamanoPoblacion = Boolean.TRUE;
	
// Cruzamiento
	// protected Cruzamiento CRUZAMIENTO = new CruzamientoSimple(3);
	// protected Cruzamiento CRUZAMIENTO = new CruzamientoMultiPunto(Arrays.asList(2, 4));
	// protected Cruzamiento CRUZAMIENTO = new CruzamientoBinomialMascaraDoble("XXYXXYX", "XXYYYYY");
	// protected Cruzamiento CRUZAMIENTO = new CruzamientoBinomialMascaraComplemento("XXYXXYX");
	// protected Cruzamiento CRUZAMIENTO = new CruzamientoBinomialAzar();
	// protected Cruzamiento CRUZAMIENTO = new CruzamientoBinomialAzarComplemento();
	// protected Cruzamiento cruzamiento = new Simple(3);
	
////////////////////////////////////////////////////////////////////////////////////
	
// Selección
	// protected MetodoDeSeleccion = new Ranking();
	// protected MetodoDeSeleccion metodoDeSeleccion = new Torneo();
	// protected MetodoDeSeleccion = new Ranking();
	// protected MetodoDeSeleccion = new Ranking();
	
// Mutación
	// protected Mutacion mutacion = new MutacionSimple(0.2);
	
}
