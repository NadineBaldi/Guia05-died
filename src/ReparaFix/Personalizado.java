package ReparaFix;

public class Personalizado extends Servicio {
	
	private Double costoTransporte;
	private Double costoMateriales;
	private Double costosAgregados; //costos por tener que tomar medidas específicas, diseñar o planificar cosas específicas 
	
	//private Double valorPresupuestado = (Servicio.getTrabajo().precio() + this.costosAgregados);
	
	//constructor
	public Personalizado(Oficio oficio, Boolean urgente, Double costoTrans, Double costoMat, Double costoAgre) {
		super(oficio, urgente);
		this.costoTransporte = costoTrans;
		this.costoMateriales = costoMat;
		this.costosAgregados = costoAgre;
	}
	
	//función para calcular el costo del servicio personalizado
	@Override
	public Double costo() {
		
		Double valorPresupuestado = (Servicio.getTrabajo().precio() + this.costosAgregados);
		
		Double suma = 0.0;
		
		suma = valorPresupuestado + this.costoMateriales + this.costoTransporte;
		
		if(this.urgente == true) {
			return suma * 1.5; //sumo el 50% por ser urgente
		} else {
			return suma;
		}
	}

}
