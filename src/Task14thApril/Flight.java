package Task14thApril;

import java.util.*;

public class Flight<T extends Passenger> {

    String flightNumber;
    List<T> passengers;

    Flight(String flightNumber) {
        this.flightNumber = flightNumber;
        this.passengers = new ArrayList<>();
    }

    void addPassenger(T passenger) {
        passengers.add(passenger);
    }

    void showPassengers() {
        System.out.println("Passengers in flight " + flightNumber + ":");
        for (T passenger : passengers) {
            System.out.println(passenger);
        }
    }
}
