//Defines the contact object with its properties like ID, name, phone, and address.
public class Contact {
  private final String contactId; // Immutable after creation
  private String firstName;
  private String lastName;
  private String phone;
  private String address;

  // Constructor
  public Contact(String contactId, String firstName, String lastName, String phone, String address) {
      // Validate contactId in the constructor as it's final
      if (contactId == null || contactId.length() > 10) {
          throw new IllegalArgumentException("Contact ID cannot be null and must be 10 characters or less.");//This also shows red during coverage
      }
      this.contactId = contactId;
      setFirstName(firstName);
      setLastName(lastName);
      setPhone(phone);
      setAddress(address);
  }

  // Getters
  public String getContactId() {
      return contactId;
  }

  public String getFirstName() {
      return firstName;
  }

  public String getLastName() {
      return lastName;
  }

  public String getPhone() {
      return phone;
  }

  public String getAddress() {
      return address;
  }
  //No setter for ContactID as is can not be updatable.
  // Setters with validation for length
  public void setFirstName(String firstName) {
      if (firstName == null || firstName.length() > 10) {
          throw new IllegalArgumentException("First name cannot be null and must be 10 characters or less.");
      }
      this.firstName = firstName;
  }

  public void setLastName(String lastName) {
      if (lastName == null || lastName.length() > 10) {
          throw new IllegalArgumentException("Last name cannot be null and must be 10 characters or less.");
      }
      this.lastName = lastName;
  }

  public void setPhone(String phone) {
      if (phone == null || !phone.matches("\\d{10}")) { // Checks for exactly 10 digits
          throw new IllegalArgumentException("Phone number cannot be null and must be exactly 10 digits.");
      }
      this.phone = phone;
  }

  public void setAddress(String address) {
      if (address == null || address.length() > 30) {
          throw new IllegalArgumentException("Address cannot be null and must be 30 characters or less.");
      }
      this.address = address;
  }
}