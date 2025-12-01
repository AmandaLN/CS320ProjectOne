import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
	//test for adding a single contact
	@Test
	void testForAddingSingleContact(){
		ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Jer", "Nelly", "1234567890", "123 Snow St");
        assertTrue(service.addContact(contact));
        assertEquals(contact, service.getContact("12345"));
	}
	//test for adding multiple contacts
	@Test
	void testForAddingMultipleContacts() {
		ContactService service = new ContactService();
        Contact contact1 = new Contact("1", "Josh", "Price", "1112223333", "456 River Ave");
        Contact contact2 = new Contact("2", "Alexandri", "Johnson", "4445556666", "789 Pine Ln");
        assertTrue(service.addContact(contact1));
        assertTrue(service.addContact(contact2));
        assertEquals(contact1, service.getContact("1"));
        assertEquals(contact2, service.getContact("2"));
	}
	//test for duplicate contact ID
	@Test
	void testForDuplicateContactId() {
		 ContactService service = new ContactService();
	        Contact contact1 = new Contact("1234", "Jane", "Miller", "0987654321", "10 Elm St");
	        Contact contact2 = new Contact("1234", "Peter", "Davis", "1231231234", "20 Maple Ave");
	        assertTrue(service.addContact(contact1));
	        assertFalse(service.addContact(contact2)); // Should not be able to add because of duplicate ID
	}
	//test for adding and retrieving contact
	@Test
	void testToAddAndRetrieve () {
		ContactService service = new ContactService();
        Contact contact = new Contact("RETRIEVE", "BillieSue", "Lee", "5556667777", "30 Lake Rd");
        service.addContact(contact);
        Contact retrievedContact = service.getContact("RETRIEVE");
        assertNotNull(retrievedContact);
        assertEquals("BillieSue", retrievedContact.getFirstName());
    }
	//test to update contact
    @Test
    void testUpdateContact() {
        ContactService service = new ContactService();
        Contact updatedContact = new Contact("New", "First", "Name", "9998887777", "New Address");
        Contact contact = null;
		service.addContact(contact);
		//shows red during coverage
        assertTrue(service.updateContact(updatedContact));
        Contact updatedContact1 = service.getContact("UPDATE");
        assertEquals("New", updatedContact1.getFirstName());
        assertEquals("Name", updatedContact1.getLastName());
        assertEquals("1112223333", updatedContact1.getPhone());
        assertEquals("New Address", updatedContact1.getAddress());
    }
    //test to delete contact
    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "Mark", "Black", "2223334444", "40 Birch Blvd");
        service.addContact(contact);
        assertTrue(service.deleteContact("1"));
        assertNull(service.getContact("1"));
    }
   }