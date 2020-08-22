package ui;

import model.Client;
import model.Store;
import exceptions.DayMismatchException;
import exceptions.UnderageException;
import exceptions.InvalidIDException;
import java.util.Scanner;

public class Main {

	private final static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Store store = new Store();
		boolean exit = false;
		System.out.println("Bienvenido al sistema de entrada de Mi Barrio te Quiere!");
		
		do {
			int options = 0;
			System.out.println("Elija una opcion:\n1. Registrar ingreso de un cliente.\n2. Consultar cantidad de intentos de entrada.\n3. Salir");
			while(options < 1 || options > 3) {
				options = sc.nextInt();
			}

			switch(options) {
				case 1:
					int idType = 0;
					options = 0;
					System.out.println("Ingrese el tipo de documento del cliente:\n1. Tarjeta de identidad\n2. Cedula de Ciudadania\n3. Pasaporte\n4. Cedula de Extranjeria");
					while(options < 1 || options > 4) {
						options = sc.nextInt();
					}
					
					switch(options) {
						case 1:
							idType = Client.TI;
							break;
						case 2:
							idType = Client.CC;
							break;
						case 3:
							idType = Client.PP;
							break;
						case 4:
							idType = Client.CE;
							break;
					}
					
					System.out.println("Ingrese el numero de documento:");
					int id = sc.nextInt();
					
					try {
						store.registerClient(idType, id);
						System.out.println("Cliente registrado con exito.");
					}catch(InvalidIDException iie) {
						System.err.println(iie.getMessage());
					}catch(UnderageException ue) {
						System.err.println(ue.getMessage());
					}catch(DayMismatchException dme) {
						System.err.println(dme.getMessage());
					}
					break;
					
				case 2:
					System.out.println("Numero de personas que han intentado ingresar: " + store.getEnterAttempts());
					break;
					
				case 3:
					exit = true;
					break;
			}
		}while(exit == false);
	}
}