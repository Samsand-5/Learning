package MultiThreading.LifeCycle;

public class MyThread extends Thread{

    @Override
    public void run(){

    }

    public static void main(String[] args) throws InterruptedException{
        MyThread t1=new MyThread();
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        Thread.sleep(100);
    }
}
