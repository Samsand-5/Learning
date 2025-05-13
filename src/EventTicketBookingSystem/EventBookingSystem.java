package EventTicketBookingSystem;

import java.util.List;

public class EventBookingSystem {

    List<Attendee> attendees;
    List<Organizer> organizers;
    List<Event> events;
    List<Tickets> tickets;

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
            if(event.title.equalsIgnoreCase(eventTitle)){
                event.setAvailableTickets(event.availableTickets-1);
                tickets.add(new Tickets(attendee, event));
                System.out.println("Tickets booked "+attendee.name+" "+attendee.id);
                return;
            }
        }
        throw new InvalidBookingException("Booking failed");
    }

    public void showEvents() {
        for (Event event : events) {
            System.out.println(event);
        }
    }


}
