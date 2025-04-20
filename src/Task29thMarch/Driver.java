package Task29thMarch;

public class Driver {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota");
        Vehicle bike = new Bike("Yamaha");
        Vehicle truck = new Truck("Volvo");

        testVehicle(car);
        System.out.println();
        testVehicle(bike);
        System.out.println();
        testVehicle(truck);
    }
    public static void testVehicle(Vehicle vehicle) {
        vehicle.start();
        vehicle.accelerate(40);
        vehicle.brake(10);
        if (vehicle instanceof AbstractVehicle) {
            ((AbstractVehicle) vehicle).displayDetails();
            System.out.println("Current speed: " + ((AbstractVehicle) vehicle).getCurrentSpeed());
        }
        vehicle.stop();
    }
}
