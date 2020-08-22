package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import exceptions.UnderageException;
import exceptions.DayMismatchException;
import exceptions.InvalidIDException;

class StoreTest {
	private Store store;
	
	private void setupStage() {
		store = new Store();
	}
	
	@Test
	public void testRegisterClient1() {
		setupStage();
		
		try {
			int id = 3064391;
			
			if(LocalDate.now().getDayOfMonth() % 2 != 0) {
				id = id + 10;
			}
			
			store.getTempClient();
			store.registerClient(Client.CC, id);
			assertEquals(store.getRegisteredClients().get(0).getId(), id);
			assertEquals(store.getRegisteredClients().get(0).getIdType(), Client.CC);
			assertEquals(store.getEnterAttempts(), 1);
		}catch(UnderageException ue) {
			fail("UnderageException not expected.");
		}catch(DayMismatchException dme) {
			fail("DayMismatchException not expected.");
		}catch(InvalidIDException iie) {
			fail("DayMismatchException not expected.");
		}
	}
	
	@Test
	public void testRegisterClient2() {
		setupStage();
		
		try {
			int id = 1203842;
			
			store.getTempClient();
			store.registerClient(Client.TI, id);
			fail("UnderageException expected.");
		}catch(UnderageException ue) {
			assertEquals(store.getRegisteredClients().size(), 0);
			assertEquals(store.getEnterAttempts(), 1);
		}catch(DayMismatchException dme){
			fail("UnderageException expected.");
		}catch(InvalidIDException iie) {
			fail("DayMismatchException not expected.");
		}
	}
	
	@Test
	public void testRegisterClient3() {
		setupStage();
		
		try {
			int id = 3064391;
			
			if(LocalDate.now().getDayOfMonth() % 2 == 0) {
				id = id + 10;
			}
			
			store.getTempClient();
			store.registerClient(Client.CC, id);
			fail("DayMismatchException expected.");
		}catch(UnderageException ue) {
			fail("DayMismatchException expected.");
		}catch(DayMismatchException dme) {
			assertEquals(store.getRegisteredClients().size(), 0);
			assertEquals(store.getEnterAttempts(), 1);
		}catch(InvalidIDException iie) {
			fail("DayMismatchException not expected.");
		}
	}
}