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


}
