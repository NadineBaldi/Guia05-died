package ReparaFix;

public class Estandar extends Servicio {
	
	private Double montoFijo;

	//constructor
	public Estandar(Oficio oficio, Boolean urgente, Double monto) {
		super(oficio, urgente);
		this.montoFijo = monto;
	}
	
	//funci�n para calcular el costo del servicio est�ndar
	@Override
	public Double costo() {
		
		Double suma = 0.0;
		
		suma = Servicio.getTrabajo().precio() + this.montoFijo;
		
		if (this.urgente == true) {
			return suma * 1.5; //sumo el 50% por ser urgente
		} else {
			return suma;
		}
	}
	
}
