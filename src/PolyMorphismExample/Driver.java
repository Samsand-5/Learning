package PolyMorphismExample;

import java.util.Scanner;

public class Driver {
    static Scanner scan = new Scanner(System.in);
    static University university = new University();
    public static void main(String[] args) {
        boolean flag = true;
        while(flag) {
            System.out.println("Enter 1 to add person\nEnter 2 to display all\nEnter 3 to exit");
            int choice = scan.nextInt();
            scan.nextLine();
            switch(choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    university.showPeople();
                    break;
                case 3:
                    flag = false;
                    break;
            }
        }

    }
    public static void addPerson() {
        System.out.println("Enter 1 to add Student\nEnter 2 to add Professor");
        int choice = scan.nextInt();
        scan.nextLine();
        switch(choice) {
            case 1:{
                System.out.println("Enter student name");
                String name = scan.nextLine();
                System.out.println("Enter student age");
                int age = scan.nextInt();
                System.out.println("Enter student id");
                int id = scan.nextInt();

                Student student = new Student(name,age,id);
                university.addPerson(student);
                break;
            }

            case 2:{
                System.out.println("Enter professor name");
                String name = scan.nextLine();
                System.out.println("Enter specialization");
                String specialization = scan.nextLine();
                System.out.println("Enter professor age");
                int age = scan.nextInt();

                Professor professor = new Professor(name, age, specialization);
                university.addPerson(professor);
                break;
            }

        }
    }
}
