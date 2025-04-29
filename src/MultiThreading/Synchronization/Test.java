package MultiThreading.Synchronization;

public class Test {
    public static void main(String[] args) {
        Counter counter=new Counter();
        MyThread2 t1=new MyThread2(counter);
        MyThread2 t2=new MyThread2(counter);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch (Exception e){

        }
        System.out.println(counter.getCount());
    }
}
