import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.Date;
import java.util.Calendar;

public class AppointmentServiceTest{
	//setup necessary object
	private AppointmentService appointmentSerivce;
	//run before every test
	@BeforeEach
	void setup() {
		appointmentSerivce = new AppointmentService();
	}
	//test to add appointment
	 @Test
	    void testAddAppointmentValid() {
	        Date futureDate = new Date(System.currentTimeMillis() + 100000);
	        Appointment appointment = new Appointment("APPT001", futureDate, "Meeting");
	        appointmentSerivce.addAppointment(appointment);
	        assertNotNull(appointmentSerivce.getAppointment("APPT001"));
	    }
	 //test for null
	    @Test
	    void testAddAppointmentNull() {
	        assertThrows(IllegalArgumentException.class, () -> {
	        	appointmentSerivce.addAppointment(null);
	        });
	    }
	    //test to delete appt
	    @Test
	    void testDeleteAppointment() {
	        Appointment appointment = new Appointment("A3", new Date(), "Review");
	        appointmentSerivce.addAppointment(appointment);
	        appointmentSerivce.deleteAppointment("A3");
	        assertNull(appointmentSerivce.getAppointment("A3")); // Verify it's gone
	    }
	    //test for non exisiting appt
	    @Test
	    void testDeleteNonExistingAppointmentThrowsException() {
	        assertThrows(IllegalArgumentException.class, () -> appointmentSerivce.deleteAppointment("NonExistent"));
	    }
	    //test null
	    @Test
	    void testDeleteNullAppointmentIdThrowsException() {
	        assertThrows(IllegalArgumentException.class, () -> appointmentSerivce.deleteAppointment(null));
	    }
	    //test empty
	    @Test
	    void testDeleteEmptyAppointmentIdThrowsException() {
	        assertThrows(IllegalArgumentException.class, () -> appointmentSerivce.deleteAppointment(""));
	    }
	
}