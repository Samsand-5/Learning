package ContactManagementSystem;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Contact> contacts;
        Scanner sc = new Scanner(System.in);

        ContactManager contactManager=new ContactManager();

        while(true){
            System.out.println("\n--- Contact Management System Menu ---");
            System.out.println("1 add Contacts");
            System.out.println("2 search By Name");
            System.out.println("3 search By Number");
            System.out.println("4 delete id");
            System.out.println("5 update contact");
            System.out.println("6 exit");
            System.out.print("Enter choice ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter id");
                    String id=sc.next();
                    System.out.println("Enter name");
                    String name=sc.next();
                    System.out.println("Enter phone number");
                    String number= sc.next();
                    System.out.println("Enter email");
                    String email=sc.next();
                    contactManager.addContact(new Contact(id,name,number,email));
                    break;

                case 2:
                    System.out.println("Enter name you want to search");
                    String s=sc.nextLine();
                    String ans = contactManager.searchByName(s);
                    System.out.println(ans);
                    break;

                case 3:
                    System.out.println("Enter number you want to search");
                    String sNumber=sc.next();
                    String res = contactManager.searchByNumber(sNumber);
                    System.out.println(res);
                    break;

                case 4:
                    System.out.println("Enter id you want to delete");
                    String sid=sc.next();
                    contactManager.deleteById(sid);
                    break;

                case 5:
                    System.out.println("Enter id of contact which you want to upgrade the parameters");
                    String pid=sc.next();
                    System.out.println("Enter new name");
                    String newName=sc.next();
                    System.out.println("Enter new phone number");
                    String newPhn=sc.next();
                    System.out.println("Enter new email id");
                    String newEmail=sc.next();
                    contactManager.updateContact(pid,newName,newPhn,newEmail);

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
