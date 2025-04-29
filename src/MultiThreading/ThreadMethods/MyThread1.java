package MultiThreading.ThreadMethods;

public class MyThread1 extends Thread{

    public MyThread1(String name){
        super(name);
    }
//    @Override
//    public void start() {
//        System.out.println("Thread is Running");
//        for(int i=0;i<5;i++){
//            try{
//                Thread.sleep(1000);
//            }
//            catch (InterruptedException e){
//                throw new RuntimeException(e);
//            }
//            System.out.println(i);
//        }
//    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+" -Priority"+
                    Thread.currentThread().getPriority()+" -count"+i);
            try{
                Thread.sleep(100);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        MyThread1 t1=new MyThread1("Soumyodip");
//        t1.start();
//        t1.join();
        System.out.println("Hello");
        t1.start();
    }
}
