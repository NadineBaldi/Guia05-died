package ReparaFix;

import java.util.ArrayList;

import ReparaFix.exceptions.AlquilerNoEntregadoException;

public class Usuario {
	
	private String dni;
	private ArrayList<Contratable> itemsContratados;
	
	//constructor
	public Usuario(String doc) {
		itemsContratados = new ArrayList<Contratable>();
		this.dni = doc;
	}
	
	//8
	public void Contratar(Contratable contr) throws AlquilerNoEntregadoException {
		
	int contHerramientas = 0;
	
	if (contr.esAlquiler()==true) { //si es un alquiler, chequeo que no haya más de 2
		
		for (int i=0; i<this.itemsContratados.size(); i++) {
			
			if(itemsContratados.get(i).esAlquiler() && contr.finalizado()==false) { //si es un alquiler y no está finalizado, contador +1
				contHerramientas++;
			}
		}
		
		if (contHerramientas >= 2) { //me fijo si hay 2 o más alquileres
			
			throw new AlquilerNoEntregadoException();
			
		} else {
			itemsContratados.add(contr); //sino, agrego el alquiler a la lista
		}
		
	} else if (contr.esTarea()==true) { //si es un servicio directamente lo agrego a la lista
		itemsContratados.add(contr);
	}
		
		
	}

}
