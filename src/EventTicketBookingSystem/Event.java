package EventTicketBookingSystem;

public class Event {

    String title;
    int availableTickets;

    Event(String title, int availableTickets){
        this.title=title;
        this.availableTickets=availableTickets;
    }

    boolean isAvailable(){
        return availableTickets>0;
    }

    void setAvailableTickets(int updateAvailableTickets){
        availableTickets=updateAvailableTickets;
    }
}
