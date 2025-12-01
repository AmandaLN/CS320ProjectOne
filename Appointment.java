import java.util.Date;

public class Appointment {
    private final String appointmentId; // Immutable after creation
    private Date appointmentDate;
    private String description;
    
 // Constructor
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        // Validate appointmentId in the constructor as it's final
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID cannot be null and must be 10 characters or less.");
        }
        this.appointmentId = appointmentId;
        setAppointmentDate(appointmentDate);
        setDescription(description);
    }
 // Getters
    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

  //No setter for AppointmentID as it cannot be up-datable.
    // Setters with validation for current or future date.
    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Appointment date cannot be null.");
        }
        // Get the current date and time
        Date currentDate = new Date(); 
        //check if appointment date is before current date.
        if (appointmentDate.before(currentDate)) {
            throw new IllegalArgumentException("Appointment date cannot be in the past.");
        }
        this.appointmentDate = appointmentDate;
    }
    // Setters with validation for length
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description cannot be null and must be 50 characters or less.");
        }
        this.description = description;
    }
}