package EventTicketBookingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Attendee> attendees = new ArrayList<>();
        List<Organizer> organizers = new ArrayList<>();
        List<Event> events = new ArrayList<>();
        List<Tickets> tickets = new ArrayList<>();

        EventBookingSystem system = new EventBookingSystem(attendees, organizers, events, tickets);

        try {
            system.loadEvents();
        } catch (Exception e) {
            System.out.println("Failed to load drivers: " + e.getMessage());
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Event Booking System Menu ---");
            System.out.println("1 Register Attendee");
            System.out.println("2 Add Event");
            System.out.println("3 Book Ticket");
            System.out.println("4 Show Events");
            System.out.println("5 Exit");
            System.out.print("Enter choice ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Attendee ID ");
                    String id = sc.nextLine();
                    System.out.print("Enter Attendee Name ");
                    String name = sc.nextLine();
                    Attendee attendee = new Attendee(id, name);
                    system.registerUser(attendee);
                    System.out.println("Attendee registered");
                    break;

                case 2:
                    System.out.print("Enter Event Title ");
                    String title = sc.nextLine();
                    System.out.print("Enter Available Tickets ");
                    int availableTickets = sc.nextInt();
                    sc.nextLine();
                    Event event = new Event(title, availableTickets);
                    system.addEvent(event);
                    System.out.println("Event added");
                    break;

                case 3:
                    System.out.print("Enter Attendee ID ");
                    String bookingId = sc.nextLine();
                    Attendee bookingAttendee = null;

                    for (Attendee a : attendees) {
                        if (a.id.equalsIgnoreCase(bookingId)) {
                            bookingAttendee = a;
                            break;
                        }
                    }

                    if (bookingAttendee == null) {
                        System.out.println("Attendee not found. Please register first");
                        break;
                    }

                    System.out.print("Enter Event Title ");
                    String eventTitle = sc.nextLine();
                    try {
                        system.bookTicket(bookingAttendee, eventTitle);
                    } catch (InvalidBookingException e) {
                        System.out.println("Error " + e.getMessage());
                    }
                    break;

                case 4:
                    system.showEvents();
                    break;

                case 5:
                    system.saveEvents();
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
