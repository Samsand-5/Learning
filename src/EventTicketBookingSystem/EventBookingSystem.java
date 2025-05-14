package EventTicketBookingSystem;

import UberRentalSystem.Ride;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EventBookingSystem {

    List<Attendee> attendees = new ArrayList<>();;
    List<Organizer> organizers = new ArrayList<>();;
    List<Event> events = new ArrayList<>();;
    List<Tickets> tickets = new ArrayList<>();;

    public EventBookingSystem(List<Attendee> attendees, List<Organizer> organizers, List<Event> events,
                              List<Tickets> tickets) {
        this.attendees = attendees;
        this.organizers = organizers;
        this.events = events;
        this.tickets = tickets;
    }

    void registerUser(User user){
        if(user instanceof Attendee){
            attendees.add((Attendee) user);
        }
        else{
            organizers.add((Organizer) user);
        }
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void bookTicket(Attendee attendee, String eventTitle) throws InvalidBookingException{
        for (Event event:events){
            if(event.title.equalsIgnoreCase(eventTitle) && event.isAvailable()){
                event.setAvailableTickets(event.availableTickets-1);
                tickets.add(new Tickets(attendee, event));
                System.out.println("Tickets booked "+attendee.name+" "+attendee.id);
                return;
            }
        }
        throw new InvalidBookingException("Booking failed");
    }

    public void showEvents() {
        for (Event event:events) {
            System.out.println(event.title+" "+event.availableTickets);
        }
    }

    void saveEvents() throws Exception {
        String path="C:\\Users\\SOUMYODIP SUTRADHAR\\OneDrive\\Desktop\\Event\\events.txt";
        File file=new File(path);
        for(Attendee attendee:attendees) {
            String message=attendee.showProfile();
            FileWriter fw=new FileWriter(file,true);
            BufferedWriter bw=new BufferedWriter(fw);

            for(int i=0;i<message.length();i++) {
                bw.write(message.charAt(i));
                bw.flush();
                fw.flush();
            }
        }
    }

    void loadEvents() throws Exception {
        String path="C:\\Users\\SOUMYODIP SUTRADHAR\\OneDrive\\Desktop\\Event\\events.txt";
        File file=new File(path);
        try(BufferedReader br=new BufferedReader(new FileReader(file))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] values = line.split(",");
                String id = values[0];
                String name = values[1];
                String status = values[2];
                System.out.println(id + " " + name + " " + status);
                Attendee attendee=new Attendee(id,name);
                EventBookingSystem obj=new EventBookingSystem(attendees,organizers,events,tickets);
                obj.registerUser(attendee);
            }
        }
    }
}
