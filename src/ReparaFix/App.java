package ReparaFix;

import java.time.Instant;

import ReparaFix.exceptions.AgendaOcupadaException;
import ReparaFix.exceptions.AlquilerNoEntregadoException;
import ReparaFix.exceptions.OficioNoCoincideException;

public class App {
	
	public static void main(String[] args) throws AgendaOcupadaException, AlquilerNoEntregadoException, OficioNoCoincideException {
		
		Herramienta h1 = new Herramienta("Pala", 50.5);
		Herramienta h2 = new Herramienta("Andamio", 100.5);
		Herramienta h3 = new Herramienta("Escalera", 250.3);
		
		Oficio of1 = new Oficio("Albañil");
		Oficio of2 = new Oficio("Carpintero");
		Oficio of3 = new Oficio("Cerrajero");
		
		Alquiler a1 = new Alquiler(h2, Instant.now(), Instant.parse("2021-05-03T10:15:30.00Z"));
		Alquiler a2 = new Alquiler(h1, Instant.now(), Instant.parse("2021-06-01T10:15:30.00Z"));
		Alquiler a3 = new Alquiler(h3, Instant.now(), Instant.parse("2021-04-01T10:15:30.00Z"));
		
		Usuario us1 = new Usuario("41403744");
		
		Trabajador t1 = new Trabajador("Matias", "mati55@gmail.com", of1, 66.5);
		
		Estandar e1 = new Estandar(of1, false, 555.1);
		Estandar e2 = new Estandar(of1, true, 555.1);
		Personalizado p1 = new Personalizado(of2, true, 400.4, 1000.0, 500.0);

		Trabajo trab1 = new Trabajo(p1, Instant.now().plusSeconds(86400));
		Trabajo trab2 = new Trabajo(e1, Instant.now().plusSeconds(86400));
		Trabajo trab3 = new Trabajo(e2, Instant.now().plusSeconds(86400));
		
		us1.Contratar(trab1);
		
		//Contratacion a1
        try {
        	us1.Contratar(a1);
        }catch(AlquilerNoEntregadoException e){
        	System.out.println("No puede contratar una nueva herramienta ya que cuenta con 2 o más sin devolver");
        }

        //Contratacion a2
        try {
        	us1.Contratar(a2);
        }catch(AlquilerNoEntregadoException e){
            System.out.println("No puede contratar una nueva herramienta ya que cuenta con 2 o más sin devolver");
        }

        //Contratacion a3 debería fallar porque tengo dos alquileres sin devolver 
        try {
        	us1.Contratar(a3);
        }catch(AlquilerNoEntregadoException e){
        	System.out.println("No puede contratar una nueva herramienta ya que cuenta con 2 o más sin devolver");
        }
        
        us1.Contratar(trab3);
        
	}

}
