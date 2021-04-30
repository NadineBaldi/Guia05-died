package ReparaFix.exceptions;

public class OficioNoCoincideException extends Exception {
	
	public OficioNoCoincideException() {
		super("El oficio de la tarea no coindice con el oficio del trabajador");
	}

}
