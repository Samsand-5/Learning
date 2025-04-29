package UberRentalSystem;

import java.util.Iterator;
import java.util.List;

@SecurityCheck(role = "Admin")
public class Admin extends User{

    public Admin(String id, String name) {
        super(id, name);
    }

    @Override
    void showProfile() {
        Class<SecurityCheck> c=SecurityCheck.class;
        SecurityCheck s=c.getDeclaredAnnotation(SecurityCheck.class);
        System.out.println(this.name+" "+s.role());
    }

    void removeDriver(List<Driver> drivers,String driverId) {
        Class<SecurityCheck> c=SecurityCheck.class;
        SecurityCheck s=c.getDeclaredAnnotation(SecurityCheck.class);
        boolean found=true;
        if(s.role().equals("Admin") && c.isAnnotationPresent(SecurityCheck.class)) {
            Iterator itr=drivers.iterator();
            while(itr.hasNext()) {
                Driver d=(Driver)itr.next();
                if(d.id.equals(driverId)) {
                    itr.remove();
                    break;
                }
            }
        }
    }
}
