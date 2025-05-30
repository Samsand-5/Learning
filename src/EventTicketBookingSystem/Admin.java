package EventTicketBookingSystem;

import java.util.Iterator;
import java.util.List;

@RoleCheck(role = "Admin")
public class Admin extends User{

    Admin(String id, String name) {
        super(id, name);
    }

    @Override
    String showProfile() {
        return "id "+id+" "+"name "+name;
    }

    void removeEvent(List<Event> events, String title){
        Iterator<Event> it = events.iterator();
        while (it.hasNext()){
            Event personExist=it.next();
            if(personExist.title.equalsIgnoreCase(title)){
                it.remove();
                System.out.println("Event person removed");
                return;
            }
        }
        System.out.println("Event person is false");
    }
}
