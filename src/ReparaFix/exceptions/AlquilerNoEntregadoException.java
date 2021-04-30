package ReparaFix.exceptions;

public class AlquilerNoEntregadoException extends Exception {
	
	public AlquilerNoEntregadoException() {
		super("No puede contratar una nueva herramienta ya que cuenta con 2 o más sin devolver");
	}

}
