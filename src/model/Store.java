package model;

import exceptions.UnderageException;
import exceptions.DayMismatchException;

import java.time.LocalDate;
import java.util.ArrayList;

public class Store {
	private int enterAttempts;
	private ArrayList<Client> registeredClients;
	
	public int getEnterAttempts() {
		return enterAttempts;
	}

	public ArrayList<Client> getRegisteredClients() {
		return registeredClients;
	}

	private Client tempClient;
	
	public Store() {
		enterAttempts = 0;
		registeredClients = new ArrayList<Client>();
		tempClient = new Client();
	}
	
	public void registerClient(int idType, int id) throws DayMismatchException, UnderageException{
		enterAttempts++;
		
		boolean even = false;
				if(LocalDate.now().getDayOfMonth() % 2 == 0) {
			even = true;
		}
			
		if(id % 2 == 0) {
			if(even) {
				throw new DayMismatchException(id);
			}
		}else {
			if(even == false) {
				throw new DayMismatchException(id);
			}
		}
		
		if(idType == Client.TI) {
			throw new UnderageException(idType);
		}
		
		registeredClients.add(new Client(idType, id));
	}
	
	public void displayAttempts() {
		System.out.println("Numero de personas que ha intentado entrar al establecimiento: " + enterAttempts);
	}

	public Client getTempClient() {
		return tempClient;
	}
}