package ContactManagementSystem;


import java.util.ArrayList;
import java.util.List;

class ContactManager
{
    private List<Contact> contactList = new ArrayList<>();
    private int nextId = 1;

    public void addContact(String name, String phoneNumber, String email)
    {
        Contact contact = new Contact(nextId++, name, phoneNumber, email);
        contactList.add(contact);
        System.out.println("Contact added successfully");
    }

    public void searchByName(String name)
    {
        boolean found = false;
        for (Contact contact : contactList)
        {
            if (contact.getName().toLowerCase().contains(name.toLowerCase()))
            {
                System.out.println(contact);
                found = true;
            }
        }
        if (!found)
            System.out.println("No contact found with that name");
    }
    public void searchByNumber(String number)
    {
        for (Contact contact : contactList)
        {
            if (contact.getPhoneNumber().contains(number))
            {
                System.out.println(contact);
                return;
            }
        }
        System.out.println("No contact found with that phone number");
    }

    public void deleteById(int id)
    {
        boolean removed = contactList.removeIf(contact -> contact.getId() == id);
        if (removed)
        {
            System.out.println("Contact deleted successfully");
        }
        else
        {
            System.out.println("No contact found with that ID");
        }
    }

    public void updateContact(int id, String newName, String newNumber, String newEmail)
    {
        for (Contact contact : contactList)
        {
            if (contact.getId() == id)
            {
                contact.setName(newName);
                contact.setPhoneNumber(newNumber);
                contact.setEmail(newEmail);
                System.out.println("Contact updated successfully");
                return;
            }
        }
        System.out.println("No contact found with that ID");
    }

    public void displayAllContacts()
    {
        if (contactList.isEmpty())
        {
            System.out.println("No contacts available.");
        }
        else
        {
            for (Contact contact : contactList)
            {
                System.out.println(contact);
            }
        }
    }
}