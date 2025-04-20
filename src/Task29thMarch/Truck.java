package Task29thMarch;

public class Truck extends AbstractVehicle{
    public Truck(String name) {
        super(name);
    }

    @Override
    public void start() {
        System.out.println(name+"Truck started");
    }

    @Override
    public void stop() {
        System.out.println(name+"Truck stopped");
    }
}
