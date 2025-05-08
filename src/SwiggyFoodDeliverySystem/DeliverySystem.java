package SwiggyFoodDeliverySystem;

import UberRentalSystem.Driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliverySystem {
    private List<Customer> customers=new ArrayList<>();
    private List<DeliveryPerson> deliveryPersons=new ArrayList<>();
    private List<Order> orders=new ArrayList<>();
    private Map<FoodItem, Integer> inventorys=new HashMap<>();

    public void registerCustomer(Customer customer) {
        customers.add(customer);
    }

    public void registerDeliveryPerson(DeliveryPerson dp) {
        deliveryPersons.add(dp);
    }

    public void addFoodItem(FoodItem item, int quantity) {
        inventorys.put(item, quantity);
    }

    public Order placeOrder(Customer customer,Map<String,Integer> requestedItems) {
        Order order=new Order(customer,requestedItems,inventorys,deliveryPersons);
        orders.add(order);
        return order;
    }

    public void displayMenu(){
        for (Map.Entry<FoodItem,Integer> entry : inventorys.entrySet()) {
            FoodItem item=entry.getKey();
            int qty=entry.getValue();
            System.out.println(item + " Stock = " + qty);
        }

    }
    public void showAllDeliveryPersons() {
        for(DeliveryPerson deliveryPerson : deliveryPersons) {
            deliveryPerson.showProfile();
        }
    }

    public Map<FoodItem,Integer> getInventory() {
        return inventorys;
    }

    public List<DeliveryPerson> getDeliveryPersons() {
        return deliveryPersons;
    }

}
