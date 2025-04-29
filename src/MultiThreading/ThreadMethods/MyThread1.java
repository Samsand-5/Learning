package MultiThreading.ThreadMethods;

public class MyThread1 extends Thread{

    @Override
    public void start() {
        System.out.println("Thread is Running");
    }

    public static void main(String[] args) {
        MyThread1 t1=new MyThread1();
        t1.start();
    }
}
