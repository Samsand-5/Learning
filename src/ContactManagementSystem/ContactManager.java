package ContactManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private List<Contact> contactList;

    public ContactManager() {
        contactList = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    public void searchByName(String name){
        int flag=0;
        for (Contact contacts:contactList){
            if(contacts.getName().equalsIgnoreCase(name)){
                flag=1;
                break;
            }
        }
        if(flag==1){
            System.out.println(name+ "is found");
        }
        else {
            System.out.println(name+ "is not found");
        }
    }
}
