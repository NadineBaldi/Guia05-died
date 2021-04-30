package ReparaFix;

import java.util.ArrayList;

import ReparaFix.exceptions.AgendaOcupadaException;
import ReparaFix.exceptions.OficioNoCoincideException;

public class Trabajador {
	
	private ArrayList<Trabajo> trabajosAsignados;
	private String nombre;
	private String correoElec;
	private Oficio oficio;
	private Double costoPorHora;
	
	//constructor
	public Trabajador(String nom, String mail, Oficio oficio, Double costo) {
		trabajosAsignados = new ArrayList<Trabajo>();
		this.nombre = nom;
		this.correoElec = mail;
		this.oficio =  oficio;
		this.costoPorHora = costo;
	}
	
	
	public ArrayList<Trabajo> getTrabajosAsignados() {
		return trabajosAsignados;
	}
	public void setTrabajosAsignados(ArrayList<Trabajo> trabajosAsignados) {
		this.trabajosAsignados = trabajosAsignados;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreoElec() {
		return correoElec;
	}
	public void setCorreoElec(String correoElec) {
		this.correoElec = correoElec;
	}
	public Oficio getOficio() {
		return oficio;
	}
	public void setOficio(Oficio oficio) {
		this.oficio = oficio;
	}
	public Double getCostoPorHora() {
		return costoPorHora;
	}
	public void setCostoPorHora(Double costoPorHora) {
		this.costoPorHora = costoPorHora;
	}
	
	
	//7
	public void agregarTareas(Trabajo t) throws OficioNoCoincideException, AgendaOcupadaException {
		
		if (this.oficio.equals(t.getTrabajador().oficio)) { //si la tarea tiene el mismo oficio que el trabajador
			
			if (this.trabajosAsignados.isEmpty()) { //si el trabajador no tiene otro trabajo asignado
				
				this.trabajosAsignados.add(t); //agrego la tarea a la lista
				
			} else {
				
				throw new AgendaOcupadaException();
			}
			
		} else { 
			
			throw new OficioNoCoincideException();
		}	
	}

}
