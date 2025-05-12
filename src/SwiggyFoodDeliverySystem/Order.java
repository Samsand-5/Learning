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

        for (Map.Entry<String,Integer> entry : requestedItems.entrySet()) {
            FoodItem isFound = null;
            for (FoodItem item : inventory.keySet()) {
                if (item.getName().equalsIgnoreCase(entry.getKey())) {
                    isFound = item;
                    break;
                }
            }
            if (isFound == null || inventory.get(isFound) < entry.getValue()) {
                throw new InvalidOrderException("stock not available" + entry.getKey());
            }
            itemsOrdered.put(isFound, entry.getValue());
        }

        for (Map.Entry<FoodItem, Integer> entry : itemsOrdered.entrySet()) {
            inventory.put(entry.getKey(), inventory.get(entry.getKey()) - entry.getValue());
        }

        this.deliveryPerson = deliveryPersons.stream()
                .filter(DeliveryPerson::isAvailable)
                .findFirst()
                .orElseThrow(() -> new InvalidOrderException("No available delivery persons."));
        this.deliveryPerson.setAvailable(false);

    }

    public void completeOrder() {
        status = "Delivered";
        deliveryPerson.setAvailable(true);
    }

    public String getStatus () {
        return status;
    }

    public String orderDetails() {
        String details = "Customer " + customer.name + "\n"
                + "DeliveryPerson " + deliveryPerson.name + "\n";

        double total = 0;
        for (Map.Entry<FoodItem, Integer> entry : itemsOrdered.entrySet()) {
            FoodItem item = entry.getKey();
            int qty = entry.getValue();
            details += item + " x " + qty + "\n";
            total += item.getPrice() * qty;
        }

        details += "Total " + total + "\n"
                + "Status " + status;

        return details;
    }

}
