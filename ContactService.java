import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts; // Stores contacts with ID as key

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    // Adding a single contact
    public boolean addContact(Contact contact) {
        if (contact == null || contact.getContactId() == null || contacts.containsKey(contact.getContactId())) {
            // Handle duplicate or invalid contact ID
            System.out.println("Error: Cannot add contact. Duplicate ID or invalid contact.");
            return false;
        }
        contacts.put(contact.getContactId(), contact);
        System.out.println("Contact added: " + contact.getContactId());
        return true;
    }

    // Adding multiple contacts
    public void addMultipleContacts(Contact... newContacts) {
       for (Contact contact : newContacts) {//red during coverage
            addContact(contact); // Reuses the single addContact method
        }
    }

    // Retrieving a contact
    public Contact getContact(String id) {
        return contacts.get(id);
    }

    // Updating a contact
    public boolean updateContact(Contact updatedContact) {
        if (updatedContact == null || updatedContact.getContactId() == null || !contacts.containsKey(updatedContact.getContactId())) {
            System.out.println("Error: Cannot update contact. Contact not found or invalid.");
            return false;
        }//shows red during coverage
        contacts.put(updatedContact.getContactId(), updatedContact); // Overwrites the existing contact
        System.out.println("Contact updated: " + updatedContact.getContactId());
        return true;
    }

    // Deleting a contact
    public boolean deleteContact(String id) {
        if (id == null || !contacts.containsKey(id)) {
            System.out.println("Error: Cannot delete contact. Contact not found.");
            return false;
        }
        contacts.remove(id);
        System.out.println("Contact deleted: " + id);
        return true;
    }
}