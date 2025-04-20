package Task29thMarch;

public class Bike extends AbstractVehicle{
    public Bike(String name) {
        super(name);
    }

    @Override
    public void start() {
        System.out.println(name+"Bike started");
    }

    @Override
    public void stop() {
        System.out.println(name+"Bike stopped");
    }
}
