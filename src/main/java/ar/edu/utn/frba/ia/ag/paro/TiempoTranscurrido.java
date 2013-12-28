package main.java.ar.edu.utn.frba.ia.ag.paro;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class TiempoTranscurrido extends CriterioDeParo {
	
	private Date horaFin = new Date();
	
	public TiempoTranscurrido(int horas, int minutos, int segundos) {
		
		Calendar calendarFin = Calendar.getInstance(); // Fecha/Hora actual
		
		calendarFin.add(Calendar.HOUR, horas); // Sumo las horas
		calendarFin.add(Calendar.MINUTE, minutos); // Sumo los minutos
		calendarFin.add(Calendar.SECOND, segundos); // Sumo los segundos
		
		this.horaFin = calendarFin.getTime();
	}
	
	@Override
	public Boolean parar(List<Individuo> individuos) {
		
		if (horaFin.before(new Date())) {
			return Boolean.TRUE;
		}
		else {
			return Boolean.FALSE;
		}
	}
}
