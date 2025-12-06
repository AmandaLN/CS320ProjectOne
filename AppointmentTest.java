import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

public class AppointmentTest{
	// Helper method to get a future date for testing
    private Date futureDate;
    	@BeforeEach
        void setUp() {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, 1); // Set to tomorrow
            futureDate = calendar.getTime();
        }
	
	//test for valid Appointment Id
    	 @Test
    	    void testAppointmentCreationValid() {
    	        Appointment appointment = new Appointment("12345", futureDate, "Meeting with client");
    	        assertNotNull(appointment);
    	        assertEquals("12345", appointment.getAppointmentId());
    	        assertEquals(futureDate, appointment.getAppointmentDate());
    	        assertEquals("Meeting with client", appointment.getDescription());
    	    }

    	    @Test
    	    void testAppointmentIdTooLong() {
    	        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678901", futureDate, "Description"));
    	    }

    	    @Test
    	    void testAppointmentIdNull() {
    	        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, futureDate, "Description"));
    	    }

    	    @Test
    	    void testAppointmentDateInPast() {
    	        Date pastDate = new Date(System.currentTimeMillis() - 100000); // 100 seconds in the past
    	        assertThrows(IllegalArgumentException.class, () -> new Appointment("123", pastDate, "Description"));
    	    }

    	    @Test
    	    void testAppointmentDateNull() {
    	        assertThrows(IllegalArgumentException.class, () -> new Appointment("123", null, "Description"));
    	    }

    	    @Test
    	    void testDescriptionTooLong() {
    	        String longDescription = "This is a very long description that exceeds the fifty-character limit for an appointment.";
    	        assertThrows(IllegalArgumentException.class, () -> new Appointment("123", futureDate, longDescription));
    	    }

    	    @Test
    	    void testDescriptionNull() {
    	        assertThrows(IllegalArgumentException.class, () -> new Appointment("123", futureDate, null));
    	    }

    	    @Test
    	    void testSetAppointmentDateValid() {
    	        Appointment appointment = new Appointment("123", futureDate, "Description");
    	        Calendar calendar = Calendar.getInstance();
    	        calendar.add(Calendar.DAY_OF_MONTH, 2);
    	        Date newFutureDate = calendar.getTime();
    	        appointment.setAppointmentDate(newFutureDate);
    	        assertEquals(newFutureDate, appointment.getAppointmentDate());
    	    }

    	    @Test
    	    void testSetAppointmentDateInPast() {
    	        Appointment appointment = new Appointment("123", futureDate, "Description");
    	        Date pastDate = new Date(System.currentTimeMillis() - 100000);
    	        assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(pastDate));
    	    }

    	    @Test
    	    void testSetDescriptionValid() {
    	        Appointment appointment = new Appointment("123", futureDate, "Old Description");
    	        appointment.setDescription("New Description");
    	        assertEquals("New Description", appointment.getDescription());
    	    }

    	    @Test
    	    void testSetDescriptionTooLong() {
    	        Appointment appointment = new Appointment("123", futureDate, "Old Description");
    	        String longDescription = "This is a very long description that exceeds the fifty-character limit for an appointment.";
    	        assertThrows(IllegalArgumentException.class, () -> appointment.setDescription(longDescription));
    	    }
}
