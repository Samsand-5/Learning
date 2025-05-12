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
        for (FoodItem foodItem : items.keySet()) {
            if (foodItem.getName().equalsIgnoreCase(itemName)) {
                foodItem.addQuantity(quantity);
                items.put(foodItem, foodItem.getQuantity()); // update quantity in map
                System.out.println("Food Restocked");
                return;
            }
        }
        FoodItem newItem = new FoodItem(itemName, 100.0, quantity); // Assuming a default price
        items.put(newItem, quantity);
        System.out.println("New item added and restocked");
    }


    @Override
    public void showProfile() {
        System.out.println("Manager " + name);
    }
}
