package ReparaFix;

public abstract class Servicio {
	
	public static Oficio oficio;
	public static Trabajador trabajador;
	public static Trabajo trabajo;
	public static Boolean urgente;
	
	protected static Double horasDeTrabajo; //defino un Double que me guarde la cantidad de horas que lleva realizar ese servicio
	
	//constructor
	public Servicio (Oficio oficio, Boolean urg) {
		this.oficio = oficio;
		this.urgente = urg;
	}
	
	public abstract Double costo();

	public static Oficio getOficio() {
		return oficio;
	}

	public static void setOficio(Oficio oficio) {
		Servicio.oficio = oficio;
	}

	public static Trabajador getTrabajador() {
		return trabajador;
	}

	public static void setTrabajador(Trabajador trabajador) {
		Servicio.trabajador = trabajador;
	}
	

	public static Trabajo getTrabajo() {
		return trabajo;
	}


	public static void setTrabajo(Trabajo trabajo) {
		Servicio.trabajo = trabajo;
	} 


	public Double getHorasDeTrabajo() {
		return horasDeTrabajo;
	}

	public void setHorasDeTrabajo(Double horasDeTrabajo) {
		this.horasDeTrabajo = horasDeTrabajo;
	} 

}
