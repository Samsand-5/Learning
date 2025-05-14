package ContactManagementSystem;

import EventTicketBookingSystem.Event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactManager {
    private List<Contact> contactList;

    public ContactManager() {
        contactList = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    public void searchByName(String name) {
        int flag = 0;
        for (Contact contacts : contactList) {
            if (contacts.getName().equalsIgnoreCase(name)) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            System.out.println(name + "is found");
        } else {
            System.out.println(name + "is not found");
        }
    }

    public void searchByNumber(String number) {
        int flag = 0;
        for (Contact contacts : contactList) {
            if (contacts.getPhoneNumber().equalsIgnoreCase(number)) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            System.out.println(number + "is found");
        } else {
            System.out.println(number + "is not found");
        }
    }

    public void deleteById(String id){
        Iterator<Contact> it = contactList.iterator();
        while (it.hasNext()){
            Contact idExist=it.next();
            if(idExist.getId().equalsIgnoreCase(id)){
                it.remove();
                System.out.println("person removed");
                return;
            }
        }
        System.out.println("person is not present");
    }

    public void updateContact(String id, String newName, String newNumber, String newEmail) {
        for (Contact contact : contactList) {
            if (contact.getId().equalsIgnoreCase(id)) {
                contact.setName(newName);
                contact.setPhoneNumber(newNumber);
                contact.setEmail(newEmail);
                System.out.println("Contact updated successfully");
                return;
            }
        }
        System.out.println("No contact found");
    }
}
