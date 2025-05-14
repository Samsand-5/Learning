package EventTicketBookingSystem;

public class Attendee extends User{

    Attendee(String id, String name) {
        super(id, name);
    }

    @Override
    public void showProfile() {
        System.out.println("id "+id+" "+"name "+name);
    }
}
