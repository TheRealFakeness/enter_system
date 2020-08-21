package model;

public class Client {
	public static final int TI = 1;
	public static final int CC = 2;
	public static final int PP = 3;
	public static final int CE = 4;
	
	private int idType;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}
	
	public Client(int idType, int id) {
		this.idType = idType;
		this.id = id;
	}
}
