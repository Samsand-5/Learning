package UberRentalSystem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RideBookingSystem system = new RideBookingSystem();
        system.customers = new ArrayList<>();
        system.drivers = new ArrayList<>();
        system.rides = new ArrayList<>();

        try {
            system.loadDriverFromFile();
        } catch (Exception e) {
            System.out.println("Failed to load drivers: " + e.getMessage());
        }

        while (true) {
            System.out.println("\n--- Ride Booking Menu ---");
            System.out.println("1. Register a Customer");
            System.out.println("2. Register a Driver");
            System.out.println("3. Book a Ride");
            System.out.println("4. Show All Drivers");
            System.out.println("5. Save Data and Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter customer ID: ");
                    String custId = sc.nextLine();
                    System.out.print("Enter customer Name: ");
                    String custName = sc.nextLine();
                    Customer cust = new Customer(custId, custName);
                    system.registerCustomer(cust);
                    break;

                case 2:
                    System.out.print("Enter driver ID: ");
                    String driverId = sc.nextLine();
                    System.out.print("Enter driver Name: ");
                    String driverName = sc.nextLine();
                    Driver driver = new Driver(driverId, driverName);
                    system.registerDriver(driver);
                    break;

                case 3:
                    System.out.print("Enter customer ID to book ride: ");
                    String id = sc.nextLine();

                    system.customers.stream()
                            .filter(c -> c.id.equals(id))
                            .findFirst()
                            .map(customerFound -> {
                                try {
                                    Ride ride = system.bookRide(customerFound);
                                    System.out.println("Ride Booked: " + ride.rideDetails());
                                } catch (InvalidRideException e) {
                                    System.out.println(e.getMessage());
                                }
                                return customerFound;
                            })
                            .orElseGet(() -> {
                                System.out.println("Customer not found.");
                                return null;
                            });
                    break;

                case 4:
                    system.showAllDrivers();
                    break;

                case 5:
                    try {
                        system.saveRides();
                        system.saveDriversToFile();
                        System.out.println("Data saved. Exiting.");
                    } catch (Exception e) {
                        System.out.println("Error saving data: " + e.getMessage());
                    }
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

