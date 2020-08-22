package exceptions;
@SuppressWarnings("serial")

public class InvalidIDException extends Exception{
	private int id;
	
	public InvalidIDException(int id) {
		super("El documento ser un numero positivo y debe tener al menos dos digitos.");
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
