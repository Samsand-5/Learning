package SwiggyFoodDeliverySystem;

public class Customer extends User {
    public Customer(String id,String name) {
        super(id, name);
    }

    @Override
    public void showProfile() {
        System.out.println("Customer Name "+name);
    }
}

