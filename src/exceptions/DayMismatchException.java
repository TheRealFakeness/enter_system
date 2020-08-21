package exceptions;

public class DayMismatchException extends Exception{
	private int id;
	
	public DayMismatchException(int id) {
		super("La paridad del penúltimo dígito del número de documento debe ser opuesta a la del día actual.");
		this.id = id;
	}

	public int getId() {
		return id;
	}
}