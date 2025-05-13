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
    public void showProfile() {
        super.showProfile();
    }
}
