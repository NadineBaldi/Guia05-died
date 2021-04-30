package ReparaFix;

public class Herramienta {
	
	private String nombre;
	private Double costoPorDia;
	
	public Herramienta (String nom, Double costo) {
		this.nombre = nom;
		this.costoPorDia = costo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getCostoPorDia() {
		return costoPorDia;
	}
	public void setCostoPorDia(Double costoPorDia) {
		this.costoPorDia = costoPorDia;
	}

}
