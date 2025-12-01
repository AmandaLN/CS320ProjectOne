import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {
	private Contact contact;
	//valid contact set up for test
	@BeforeEach
	void setUp(){
		contact = new Contact("6855", "Jer", "Nelly", "1234567898", "255 Snowy St");
		
	}
	//test creating contact
		@Test
		void testCreateContact() {
			 assertNotNull(contact);
		        assertEquals("6855", contact.getContactId());
		        assertEquals("Jer", contact.getFirstName());
		        assertEquals("Nelly", contact.getLastName());
		        assertEquals("1234567898", contact.getPhone());
		        assertEquals("255 Snowy St", contact.getAddress());
	    }
		//test for first name
		@Test
		void testFirstName() {
			 contact.setFirstName("Jane");
		        assertEquals("Jane", contact.getFirstName());
		}
		//test for invalidFirstName
		@Test
		void testInvalidFirstName() {
			 assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
		     assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("TooLongFirstName"));
		}
		//test for last name
		@Test
		void testLastName() {
			contact.setLastName("Johnston");
			assertEquals("Johnston", contact.getLastName());
		}
		//test for invalid last name
		@Test
		void testInvalidLastName() {
			 assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
		     assertThrows(IllegalArgumentException.class, () -> contact.setLastName("TooLongLastName"));
		}
		//test for phone
		@Test
		void testPhone() {
			contact.setPhone("1234567888");
			assertEquals("1234567888", contact.getPhone());
		}
		//tests for invalid phone
		@Test
		void testInvalidPhone() {
			  assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
		      assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123")); // Too short
		      assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345678901")); // Too long
		      assertThrows(IllegalArgumentException.class, () -> contact.setPhone("abcdefghij")); // Non-digit characters
		}
		//test for address
		@Test
		void testValidAddress() {
			 contact.setAddress("456 Main Rd");
		        assertEquals("456 Main Rd", contact.getAddress());
		}
		//test for invalid address
		@Test
		void testInvalidAddress() {
			 assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
		     assertThrows(IllegalArgumentException.class, () -> contact.setAddress("This address is way too long and exceeds the thirty character limit."));
		}
}
