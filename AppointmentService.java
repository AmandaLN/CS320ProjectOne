import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService{
	private final Map<String, Appointment> appointments; //stores appts by the ID
	public AppointmentService() {
        this.appointments = new HashMap<>();
    }
	//add appointment to service
	public void addAppointment(Appointment appointment) {
		if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null.");
        }
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment with ID " + appointment.getAppointmentId() + " already exists.");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
	}
	//deletes appointment from service
	public void deleteAppointment(String appointmentId) {
        if (appointmentId == null || appointmentId.isEmpty()) {
            throw new IllegalArgumentException("Appointment ID cannot be null or empty.");
        }
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment with ID " + appointmentId + " not found.");
        }
        appointments.remove(appointmentId);
    }
	//get appointment by Id used for testing
	public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
	
}