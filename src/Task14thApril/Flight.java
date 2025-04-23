package Task14thApril;

import java.util.*;

public class Flight<T extends Passenger> {

    String flightNumber;
    List<T> passengers;

    Flight(String flightNumber) {
        this.flightNumber = flightNumber;
        this.passengers = new ArrayList<>();
    }
}
