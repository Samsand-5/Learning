package Task29thMarch;

abstract class AbstractVehicle implements Vehicle{
    protected String name;
    protected int speed;

    public AbstractVehicle(String name) {
        this.name = name;
        this.speed = 0;
    }

    public int getCurrentSpeed() {
        return speed;
    }

    public void displayDetails() {
        System.out.println("Vehicle "+name+",Speed "+speed +"km/h");
    }


    @Override
    public void accelerate(int increment) {
        speed+=increment;
    }

    @Override
    public void brake(int decrement) {
        speed-=decrement;
    }
}
