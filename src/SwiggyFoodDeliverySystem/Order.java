package SwiggyFoodDeliverySystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private Customer customer;
    private DeliveryPerson deliveryPerson;
    private Map<FoodItem, Integer> itemsOrdered;
    private String status;

    public Order(Customer customer, Map<String, Integer> requestedItems,
                 Map<FoodItem, Integer> inventory, List<DeliveryPerson> deliveryPersons) {
        this.customer = customer;
        this.status = "Placed";
        this.itemsOrdered = new HashMap<>();


    }

    public Customer getCustomer() {
        return customer;
    }

    public DeliveryPerson getDeliveryPerson() {
        return deliveryPerson;
    }

    public Map<FoodItem, Integer> getItemsOrdered() {
        return itemsOrdered;
    }

    public String getStatus() {
        return status;
    }

}
