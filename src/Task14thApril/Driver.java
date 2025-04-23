package Task14thApril;

public class Driver {
    public static void main(String[] args) {
        //Normal passengers
        Flight<Passenger> normalFlight = new Flight<>("A113");
        Passenger p1 = new Passenger("Soumyodip");
        normalFlight.addPassenger(p1);

        //VIP passengers
        Flight<VipPassenger> vipFlight = new Flight<>("B556");
        VipPassenger p2 = new VipPassenger("Tathagata");
        vipFlight.addPassenger(p2);

        // Passengers display
        normalFlight.showPassengers();
        System.out.println();
        vipFlight.showPassengers();
    }
}
