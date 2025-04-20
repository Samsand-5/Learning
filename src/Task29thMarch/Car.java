package Task29thMarch;

public class Car extends AbstractVehicle{
    public Car(String name) {
        super(name);
    }

    @Override
    public void start() {
        System.out.println(name+"Car started");
    }

    @Override
    public void stop() {
        System.out.println(name+"Car stopped");
    }
}
