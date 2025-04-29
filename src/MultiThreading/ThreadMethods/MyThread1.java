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

//    @Override
//    public void run() {
//        for(int i=0;i<5;i++){
//            System.out.println(Thread.currentThread().getName()+" -Priority"+
//                    Thread.currentThread().getPriority()+" -count"+i);
//            try{
//                Thread.sleep(100);
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//    }

    @Override
    public void run(){
        try {
            Thread.sleep(1000);
            System.out.println("Thread");
        } catch (InterruptedException e) {
            System.out.println("Thread interupted "+e);
        }
    }

    public static void main(String[] args) throws InterruptedException{
//        MyThread1 t1=new MyThread1("LOW");
//        MyThread1 t2=new MyThread1("MEDIUM");
//        MyThread1 t3=new MyThread1("HIGH");
////        t1.start();
////        t1.join();
//        System.out.println("Hello");
//        t1.setPriority(Thread.MIN_PRIORITY);
//        t2.setPriority(Thread.NORM_PRIORITY);
//        t3.setPriority(Thread.MAX_PRIORITY);
//        t1.start();
//        t2.start();
//        t3.start();

        MyThread1 t1=new MyThread1("MESSI");
        t1.start();
        t1.interrupt();
    }
}
