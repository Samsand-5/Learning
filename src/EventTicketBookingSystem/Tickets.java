package EventTicketBookingSystem;

public class Tickets {

    Attendee attendee;
    Event event;
    String status;

    Tickets(Attendee attendee, Event event){
        this.attendee=attendee;
        this.event=event;
        this.status="Booked";
    }

    void cancel(){
        status="Cancelled";
    }

    String getStatus(){
        return status;
    }

    String ticketDetails(){
        return attendee.id+" "+attendee.name+" "+event.title+" "+status;
    }
}
