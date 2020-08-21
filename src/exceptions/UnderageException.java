package exceptions;

public class UnderageException extends Exception{
	private int idType;
	public UnderageException(int idType){
		super("El tipo de documento no puede ser TI");
		this.idType = idType;
	}
	
	public int getIdType() {
		return idType;
	}
}
