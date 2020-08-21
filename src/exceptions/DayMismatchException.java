package exceptions;

public class DayMismatchException extends Exception{
	private int id;
	
	public DayMismatchException(int id) {
		super("La paridad del pen�ltimo d�gito del n�mero de documento debe ser opuesta a la del d�a actual.");
		this.id = id;
	}

	public int getId() {
		return id;
	}
}