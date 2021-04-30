package ReparaFix.exceptions;

public class AgendaOcupadaException extends Exception {
	
	public AgendaOcupadaException() {
		super("El trabajador ya tiene otro trabajo asignado ese día");
	}
}
