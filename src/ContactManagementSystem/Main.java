package ContactManagementSystem;

import java.util.Scanner;

public class Main
{
    static Scanner sc = new Scanner(System.in);
    static ContactManager cm = new ContactManager();
    static Contact contact = new Contact();
    public static void input()
    {
        System.out.println("Welcome to Contact Manager");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Operations:\n1) Add Contact\t2) Search by Name\n3) Delete by ID\t4) Update Contact\n5) Search By Number\t6) Display All Contact");
        System.out.println("---------------------------------------------------------------------------------------");

        int choice = sc.nextInt();
        sc.nextLine(); // consume newline
        switch (choice)
        {
            case 1:
                System.out.println("Enter Name");
                String name = sc.nextLine();
                boolean isValid = contact.setName(name);
                if(!isValid)
                {
                    System.out.println("Invalid Name\nPlease Enter A Valid Name");
                    contact.setName(sc.nextLine());
                }
                System.out.println("Enter Phone Number");
                String number = sc.nextLine();
                boolean isValid2 = contact.setPhoneNumber(number);
                if(!isValid2)
                {
                    System.out.println("Invalid Phone Number\nEnter a Valid Phone Number");
                    contact.setName(sc.nextLine());
                }
                System.out.println("Enter Email ID");
                String email = sc.nextLine();
                boolean isValid3 = contact.setEmail(email);
                if(!isValid3)
                {
                    System.out.println("Invalid Email");
                    contact.setEmail(sc.nextLine());
                }
                cm.addContact(name, number, email);
                break;
            case 2:
                System.out.println("Enter Name");
                String n = sc.nextLine();
                cm.searchByName(n);
                break;
            case 3:
                System.out.println("Enter ID");
                int delId = sc.nextInt();
                sc.nextLine(); // consume newline
                cm.deleteById(delId);
                break;
            case 4:
                System.out.println("Enter ID");
                int id2 = sc.nextInt();
                sc.nextLine(); // consume newline
                System.out.println("New Name");
                String newName = sc.nextLine();
                System.out.println("New Number");
                String newNumber = sc.nextLine();
                System.out.println("New Email");
                String newEmail = sc.nextLine();
                cm.updateContact(id2, newName, newNumber, newEmail);
                break;
            case 5:
                System.out.println("Enter Number");
                cm.searchByNumber(sc.nextLine());
                break;
            case 6:
                cm.displayAllContacts();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void main(String[] args)
    {
        int choice;
        do {
            input();
            System.out.println("Press 1 to continue");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline
        } while (choice == 1);
    }
}
