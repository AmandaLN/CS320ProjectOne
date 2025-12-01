import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

public class AppointmentTest{
	//test for valid Appointment Id
	@Test
    void testValidAppointmentId() {
		String validId = "APPT12345"; // 9 characters, valid
        Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24); // Tomorrow
        String description = "Valid for check-up";
        
        Appointment appointment = new Appointment(validId, futureDate, description);
        assertNotNull(appointment);
        assertEquals("APPT001", appointment.getAppointmentId());
    }

    @Test
    void testNullAppointmentId() {
    	String nullId = null;
        Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
        String description = "Not valid null ID";
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(nullId,  futureDate, description);
        });
    }

    @Test
    void testLongAppointmentId() {
        String longId = "APPT1234567890"; // 14 characters, too long
        Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
        String description = "Id too long";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(longId, futureDate, description);
        });
        assertEquals("Appointment ID cannot be null and must be 10 characters or less.", exception.getMessage());
    }
    //test for exactly 10 characters
    @Test
    void testTenCharacterId() {
    	String tenCharId = "APPT659735";
    	Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
        String description = "Follow-up appointment";

        Appointment appointment = new Appointment(tenCharId, futureDate, description);
        assertNotNull(appointment);
        assertEquals(tenCharId, appointment.getAppointmentId());
    }
	//test that past date throws IllegalArgumentExeption
	@Test
	void testPastDate() {
		//create past date
		Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1); // One day in the past
        Date pastDate = cal.getTime();

        // Assert that  an appointment with a past date throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> 
            new Appointment("ID1", pastDate, "Past appointment")
        );
	}
	//test for date null
	@Test
    void testAppointmentDateCannotBeNull() {
        // Assert that creating an appointment with a null date throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("ID2", null, "Null date appointment")
        );
    }
	//test for valid date
	@Test
	void testValidDate() {
		//create future date
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);//one day in future
		Date futureDate = cal.getTime();
	
	//assert does not throw for valid future date
		assertDoesNotThrow(() -> {
			Appointment appointment = new Appointment("ID3", futureDate, "Future appointment");
			assertNotNull(appointment);
			assertEquals(futureDate, appointment.getAppointmentDate());
    });
}
	//tests for valid description length
	@Test
	void validDescriptionLength() {
		String validDescription = "This is a valid appointment description.";
		assertDoesNotThrow(() -> {
            Appointment appointment = new Appointment("123", new Date(), validDescription);
            assertEquals(validDescription, appointment.getDescription());
        });
	}
	//test for null description
	@Test
	void testNullDescription() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", new Date(), null); 
        });
        assertEquals("Description cannot be null", thrown.getMessage());
	}
	//test for empty description
	@Test
	void testEmptyDescription() {
		 IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
	            new Appointment("123", new Date(), "");
	        });
	        assertEquals("Description cannot be empty", thrown.getMessage());
	}
	//test for description over 50 characters
	@Test
	void testDescriptionOverFiftyCharacters() {
		String longDescription = "This is a very very very very long description that exceeds the fifty character limit for the appointment object's length of description field.";

        // Verify that passing a description throws an IllegalArgumentException
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", new Date(), longDescription);
        });
        assertEquals("Description cannot be longer than 50 characters", thrown.getMessage());
	}
}