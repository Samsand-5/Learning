package EventTicketBookingSystem;

public class Attendee extends User{

    Attendee(String id, String name) {
        super(id, name);
    }

    @Override
    public String showProfile() {
        return "id "+id+" "+"name "+name;
    }
}
