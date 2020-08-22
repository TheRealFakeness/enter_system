package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import exceptions.UnderageException;
import exceptions.DayMismatchException;

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
				id++;
			}
			
			store.getTempClient();
			store.registerClient(Client.CC, id);
			assertEquals(store.getRegisteredClients().get(0).getId(), id);
			assertEquals(store.getRegisteredClients().get(0).getIdType(), Client.CC);
		}catch(UnderageException ue) {
			fail("UnderageException not expected.");
		}catch(DayMismatchException dme) {
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
		}catch(DayMismatchException dme){
			fail("UnderageException expected.");
		}
	}
	
	@Test
	public void testRegisterClient3() {
		setupStage();
		
		try {
			int id = 3064391;
			
			if(LocalDate.now().getDayOfMonth() % 2 == 0) {
				id++;
			}
			
			store.getTempClient();
			store.registerClient(Client.CC, id);
			fail("DayMismatchException expected.");
		}catch(UnderageException ue) {
			fail("DayMismatchException expected.");
		}catch(DayMismatchException dme) {
			assertEquals(store.getRegisteredClients().size(), 0);
		}
	}
}