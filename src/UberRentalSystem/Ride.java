package UberRentalSystem;

public class Ride {
    Customer customer;
    Driver driver;
    String status;

    public Ride(Customer customer,Driver driver) {
        this.customer=customer;
        this.driver=driver;
        this.status="Booked";
    }

    void completeRide() {
        this.status="Completed";
        driver.setAvailability(true);
    }

    String getStatus() {
        return this.status;
    }

    String rideDetails() {
        return customer.name+" "+driver.name+" "+status;
    }
}
