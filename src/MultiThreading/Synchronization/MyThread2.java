package MultiThreading.Synchronization;

public class MyThread2 extends Thread{

    private Counter counter;

    public  MyThread2(Counter counter){
        this.counter=counter;
    }
}
