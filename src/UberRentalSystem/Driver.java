package UberRentalSystem;

public class Driver extends User{

    private boolean available;
    public Driver(String id, String name) {
        super(id, name);
        this.available=true;
    }

    @Override
    void showProfiles() {
        System.out.println(this.available+" "+this.name);
    }

    boolean isAvailable() {
        return this.available;
    }

    void setAvailability(boolean available) {
        this.available=available;
    }

    public String getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}