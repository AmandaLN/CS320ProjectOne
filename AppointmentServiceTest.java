import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.Date;
import java.util.Calendar;

public class AppointmentServiceTest{
	private AppointmentService service;
    private Date futureDate;

    @BeforeEach
    void setUp() {
        service = new AppointmentService();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1); // Set to tomorrow
        futureDate = calendar.getTime();
    }

    @Test
    void testAddAppointmentValid() {
        Appointment appointment = new Appointment("A1", futureDate, "Dentist appointment");
        service.addAppointment(appointment);
        assertNotNull(service.getAppointment("A1"));
        assertEquals(appointment, service.getAppointment("A1"));
    }

    @Test
    void testAddAppointmentDuplicateId() {
        Appointment appointment1 = new Appointment("A1", futureDate, "Dentist appointment");
        service.addAppointment(appointment1);
        Appointment appointment2 = new Appointment("A1", futureDate, "Another appointment");
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appointment2));
    }

    @Test
    void testAddAppointmentNull() {
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(null));
    }

    @Test
    void testDeleteAppointmentValid() {
        Appointment appointment = new Appointment("A1", futureDate, "Dentist appointment");
        service.addAppointment(appointment);
        service.deleteAppointment("A1");
        assertNull(service.getAppointment("A1"));
    }

    @Test
    void testDeleteAppointmentNonExistent() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("NonExistentId"));
    }

    @Test
    void testDeleteAppointmentNullId() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment(null));
    }
}
