package EventTicketBookingSystem;

import java.util.List;

@RoleCheck(role = "Admin")
public class Admin extends User{

    Admin(String id, String name) {
        super(id, name);
    }

    void removeEvent(List<Event> events, String title){

    }
}
