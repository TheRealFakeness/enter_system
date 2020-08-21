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
		int id = 3064391;
		
		if(LocalDate.now().getDayOfMonth() % 2 != 0) {
			id++;
		}
		
		try {
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
}