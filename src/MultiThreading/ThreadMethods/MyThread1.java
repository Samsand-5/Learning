package MultiThreading.ThreadMethods;

public class MyThread1 extends Thread{

    @Override
    public void start() {
        System.out.println("Thread is Running");
        for(int i=0;i<14;i++){
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MyThread1 t1=new MyThread1();
        t1.start();
    }
}
