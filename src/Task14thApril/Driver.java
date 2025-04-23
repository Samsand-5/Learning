package Task14thApril;

public class Driver {
    public static void main(String[] args) {
        //Normal passengers
        Flight<Passenger> economyFlight = new Flight<>("A113");
        Passenger john = new Passenger("Soumyodip");
        economyFlight.addPassenger(john);

        //VIP passengers
        Flight<VipPassenger> vipFlight = new Flight<>("B556");
        VipPassenger alice = new VipPassenger("Tathagata");
        vipFlight.addPassenger(alice);

        // Passengers display
        economyFlight.showPassengers();
        vipFlight.showPassengers();
    }
}
