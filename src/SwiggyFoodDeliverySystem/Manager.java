package SwiggyFoodDeliverySystem;

import java.util.Iterator;
import java.util.List;

@RoleCheck(role = "Manager")
public class Manager extends User{
    Manager(String id, String name) {
        super(id, name);
    }

    public void removeDeliveryPerson(List<DeliveryPerson> deliveryPersons, String id){
        Iterator<DeliveryPerson> it= deliveryPersons.iterator();
        while (it.hasNext()){
            DeliveryPerson deliveryPerson=it.next();
            if(deliveryPerson.id.equals(id)){
                it.remove();
                return;
            }
        }
    }

    public void restockItem(List<FoodItem> items, String itemName, int quantity){

    }

    @Override
    public void showProfile() {
        System.out.println("Manager " + name);
    }
}
