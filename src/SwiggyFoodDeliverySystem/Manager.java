package SwiggyFoodDeliverySystem;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
                System.out.println("Delivery person added");
                return;
            }
        }
        System.out.println("Delivery person is false");
    }

    public void restockItem(Map<FoodItem, Integer> items, String itemName, int quantity){
        for (FoodItem fooditem : items.keySet()){
            if(fooditem.getName().equals(itemName)){
                fooditem.addQuantity(quantity);
                System.out.println("Food Restocked");
                return;
            }
        }
        System.out.println("Item not present");
    }

    @Override
    public void showProfile() {
        System.out.println("Manager " + name);
    }
}
