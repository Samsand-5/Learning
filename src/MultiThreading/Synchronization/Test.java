package MultiThreading.Synchronization;

public class Test {
    public static void main(String[] args) {
        Counter counter=new Counter();
        MyThread2 t2=new MyThread2(counter);
    }
}
