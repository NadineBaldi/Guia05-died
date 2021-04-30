package ReparaFix;

import java.time.Instant;

public class Trabajo implements Contratable {
	
	private Trabajador trabajador;
	private Servicio servicio;
	private Instant fechaFin;
	
	private Double precioTrabajo; //precio del trabajo realizado (sin tener en cuenta que tipo de servicio realizó). Luego calculo eso en Estandar y  Personalizado
	
	//constructor
	public Trabajo (Servicio servicio, Instant fecha) {
		this.fechaFin = fecha;
		this.servicio = servicio;
	}
	
	@Override
	public Double precio() { 
		precioTrabajo = Servicio.getTrabajador().getCostoPorHora() * Servicio.horasDeTrabajo;
		return precioTrabajo; 
	}
	
	@Override
	public Boolean finalizado() {
		
		if (this.fechaFin != null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public Boolean esAlquiler() {
		return false;
	}

	public Boolean esTarea() {
		return true;
	}  
	
	
	public Trabajador getTrabajador() {
		return trabajador;
	}
	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Instant getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Instant fechaFin) {
		this.fechaFin = fechaFin;
	}

}
