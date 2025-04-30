package MultiThreading.VolatileAndAtomic;

public class VolatileCounter {

    private int counter=0;

    public void increment(){
        counter++;
    }

    public int getCounter(){
        return counter;
    }

}
