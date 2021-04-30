package ReparaFix;

import java.time.Duration;
import java.time.Instant;

public class Alquiler implements Contratable {
	
	private Herramienta herramienta;
	private Instant fechaInicio;
	private Instant fechaFin;
	private Instant fechaRealDevolucion = null; //queda vacía hasta que se devuelva la herramienta
	
	//constructor
	public Alquiler(Herramienta herramienta, Instant fechaIn, Instant fechaF) {
		this.herramienta = herramienta;
		this.fechaInicio = fechaIn;
		this.fechaFin = fechaF;
	}
	
	//5
	public final void iniciar(Instant fechaIni) {
		this.fechaInicio = fechaIni;
	}
	
	public final void finalizar(Instant fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	//cuando se devuelve la herramienta, fechaRealDevolución guarda esa fecha 
	public final void finalizarReal(Instant fechaDevolucion) {
		this.fechaRealDevolucion = Instant.now();
	}
	
	//días transcurridos entre el inicio del alquiler y la devolución
	public Long dias() { 
		return Duration.between(fechaInicio, fechaRealDevolucion).toDays();
	}

	//calculo el costo del alquiler multiplicando el costo por día de la herramienta por la cantidad de días que se usó	
	public Double precio() {

		Double costo = 0.0;
		costo = herramienta.getCostoPorDia() * this.dias();
		return costo;
	}
	
	//días transcurridos entre la fecha real de devolución y la que estaba pautada
	public Long diasEnMora() {
		return Duration.between(fechaFin, fechaRealDevolucion).toDays();
	}
	
	public Boolean enMora() {
		//si ya lo devolvió (finalizado=true) y la diferencia de días entre la devolución real y la pautada es distinta de 0
		//o si aún no lo devolvío, se encuentra enMora
		if((this.finalizado()==true && this.diasEnMora() != 0) || this.finalizado() == false) {
			return true;
		} else {
			return false;
		}
	}
	
	
	//6 
	public Boolean finalizado() {
		
		if (this.fechaRealDevolucion != null) {
			return true;
		} else {
			return false;
		}
	}

	
	public Boolean esAlquiler() {
		return true;
	}

	public Boolean esTarea() {
		return false;
	}	
}
