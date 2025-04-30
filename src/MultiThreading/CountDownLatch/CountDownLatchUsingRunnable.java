package MultiThreading.CountDownLatch;

import java.util.concurrent.*;

public class CountDownLatchUsingRunnable {
    public static void main(String[] args) throws ExecutionException,InterruptedException {
        int numberOfServices=3;
        CountDownLatch latch=new CountDownLatch(numberOfServices);
        for(int i=0;i<numberOfServices;i++){
            new Thread(new DependentService1(latch)).start();
        }
        latch.await();
        System.out.println("Main");
    }

}
class DependentService1 implements Runnable {

    private final CountDownLatch latch;

    public DependentService1(CountDownLatch latch){
        this.latch=latch;
    }
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+" Service started");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            latch.countDown();
        }
    }
}

