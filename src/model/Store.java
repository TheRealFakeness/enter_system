package model;

import exceptions.UnderageException;
import exceptions.DayMismatchException;
import exceptions.InvalidIDException;

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

	public Store() {
		enterAttempts = 0;
		registeredClients = new ArrayList<Client>();
	}
	
	public void registerClient(int idType, int id) throws DayMismatchException, UnderageException, InvalidIDException{
		if(id < 10) {
			throw new InvalidIDException(id);
		}
		
		enterAttempts++;
		
		if(idType == Client.TI) {
			throw new UnderageException(idType);
		}
		
		boolean even = false;
		int secondToLastDigit = Math.abs((id%100)/10);
		
		if(LocalDate.now().getDayOfMonth() % 2 == 0) {
			even = true;
		}
		
		if(secondToLastDigit % 2 == 0) {
			if(even) {
				throw new DayMismatchException(id);
			}
		}else {
			if(even == false) {
				throw new DayMismatchException(id);
			}
		}
		
		registeredClients.add(new Client(idType, id));
	}
	
	public void displayAttempts() {
		System.out.println("Numero de personas que ha intentado entrar al establecimiento: " + enterAttempts);
	}
}