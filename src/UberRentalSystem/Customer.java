package UberRentalSystem;

public class Customer extends User{

    public Customer(String id, String name) {
        super(id, name);
    }

    @Override
    void showProfile() {
        System.out.println(this.id+" "+this.name);
    }

}