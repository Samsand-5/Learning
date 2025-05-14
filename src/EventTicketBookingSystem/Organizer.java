package EventTicketBookingSystem;

public class Organizer extends User{

    boolean active = true;

    Organizer(String id, String name) {
        super(id, name);
    }

    boolean isActive(){
        return active;
    }

    void setActive(boolean updateActive){
        active=updateActive;
    }

    @Override
    public String showProfile() {
        System.out.println("id "+id+" "+"name "+name);
        System.out.println(" "+active);
        return null;
    }
}
