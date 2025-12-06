import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService{
	private final Map<String, Appointment> appointments; //stores appts by the ID
	public AppointmentService() {
        this.appointments = new HashMap<>();
    }

    public void addAppointment(Appointment appointment) {
        if (appointment == null || appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment already exists or is null.");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    public void deleteAppointment(String appointmentId) {
        if (appointmentId == null || !appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment does not exist or ID is null.");
        }
        appointments.remove(appointmentId);
    }

    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
	
}
