package SwiggyFoodDeliverySystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliverySystem {
    private List<Customer> customers = new ArrayList<>();
    private List<DeliveryPerson> deliveryPersons = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private Map<FoodItem, Integer> inventory = new HashMap<>();

}
