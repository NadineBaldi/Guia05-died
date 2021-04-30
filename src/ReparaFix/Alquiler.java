package ReparaFix;

import java.time.Duration;
import java.time.Instant;

public class Alquiler implements Contratable {
	
	private Herramienta herramienta;
	private Instant fechaInicio;
	private Instant fechaFin;
	private Instant fechaRealDevolucion = null; //queda vac�a hasta que se devuelva la herramienta
	
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
	
	//cuando se devuelve la herramienta, fechaRealDevoluci�n guarda esa fecha 
	public final void finalizarReal(Instant fechaDevolucion) {
		this.fechaRealDevolucion = Instant.now();
	}
	
	//d�as transcurridos entre el inicio del alquiler y la devoluci�n
	public Long dias() { 
		return Duration.between(fechaInicio, fechaRealDevolucion).toDays();
	}

	//calculo el costo del alquiler multiplicando el costo por d�a de la herramienta por la cantidad de d�as que se us�	
	public Double precio() {

		Double costo = 0.0;
		costo = herramienta.getCostoPorDia() * this.dias();
		return costo;
	}
	
	//d�as transcurridos entre la fecha real de devoluci�n y la que estaba pautada
	public Long diasEnMora() {
		return Duration.between(fechaFin, fechaRealDevolucion).toDays();
	}
	
	public Boolean enMora() {
		//si ya lo devolvi� (finalizado=true) y la diferencia de d�as entre la devoluci�n real y la pautada es distinta de 0
		//o si a�n no lo devolv�o, se encuentra enMora
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
