package SwiggyFoodDeliverySystem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DeliverySystem system=new DeliverySystem();
        Manager manager = new Manager("M1", "Admin");

        while (true) {
            System.out.println("\n1. Register Customer\n2. Register Delivery Person\n3. Show Menu & Place Order\n4. Restock Item\n5. Show All Delivery Persons\n6. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID and Name: ");
                    String id = sc.next(), name = sc.nextLine().trim();
                    system.registerCustomer(new Customer(id, name));
                }
                case 2 -> {
                    System.out.print("Enter ID and Name: ");
                    String id = sc.next(), name = sc.nextLine().trim();
                    system.registerDeliveryPerson(new DeliveryPerson(id, name));
                }
                case 3 -> {
                    system.displayMenu();
                    System.out.print("Enter customer name: ");
                    String custName = sc.nextLine();
                    Customer customer = new Customer("C" + custName.hashCode(), custName);
                    Map<String, Integer> items = new HashMap<>();
                    System.out.print("How many items? ");
                    int n = sc.nextInt(); sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter item name and quantity: ");
                        String itemName = sc.next();
                        int qty = sc.nextInt();
                        items.put(itemName, qty);
                    }
                    try {
                        Order order = system.placeOrder(customer, items);
                        System.out.println("Order placed successfully!");
                        System.out.println(order.orderDetails());
                    } catch (InvalidOrderException e) {
                        System.out.println("Order failed: " + e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.print("Enter item name and quantity: ");
                    String itemName = sc.next();
                    int qty = sc.nextInt();
                    manager.restockItem(system.getInventory(), itemName, qty);
                }
                case 5 -> system.showAllDeliveryPersons();
                case 6 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}

