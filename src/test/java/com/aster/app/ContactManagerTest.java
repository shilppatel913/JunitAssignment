package com.aster.app;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class ContactManagerTest {

	 ContactManager manager=null;
	
	@BeforeAll
	 void setUp() {
		manager=new ContactManager();
	}
	
	@Test
	@DisplayName("ShouldCreateContact")
	 void checkCreateContact() {
		manager.getAllContacts().clear();
		assertAll(()->{
			manager.addContact("Shilp","Patel", "0937549997");
			assertEquals(1,manager.getAllContacts().size());
			manager.addContact("Isha","Sachdeva","0766876535");
			assertEquals(2,manager.getAllContacts().size());
		});
	}
	
	@Test
	@DisplayName("ShouldNotCreateContactWhenFirstNameisNull")
	 void checkNoContactWhenNull() {
		Throwable exception=assertThrows(RuntimeException.class, ()->{
			manager.addContact(null,"Sharma","0932755561");
		});
		
		assertEquals("First Name Cannot be null or empty",exception.getMessage());
	}
	
	@Test
	@DisplayName("PhoneNumbershouldstartwith0")
	 void checkPhoneNumberStartWithZero() {
		System.out.println(manager.getAllContacts().toString());
		
		assertAll(()->{
			Throwable exception=assertThrows(RuntimeException.class, ()->{
				manager.addContact("Rohit","Sharma","9327555611");
			});
			
			if(exception.getMessage().length()>0) {
				assertEquals("Phone Number Should Start with 0", exception.getMessage());
			}
			
			/* Phone number starts with 0 so gets added */ 
			manager.addContact("Sharan","Shriya","0932755561");
			assertEquals(1,manager.getAllContacts().size());
		});
		
	}
	
	@Test
	@Disabled("NotInUse")
	 void deletedNumbers() {
		
	}
	
	@AfterAll
	private void clean() {
		manager=null;
	}
	
}
