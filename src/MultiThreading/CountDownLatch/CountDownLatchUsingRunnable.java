package MultiThreading.CountDownLatch;

import java.util.concurrent.*;

public class CountDownLatchUsingRunnable {
    public static void main(String[] args) throws ExecutionException,InterruptedException {
        int numberOfServices=3;
        ExecutorService executorService= Executors.newFixedThreadPool(numberOfServices);
        CountDownLatch latch=new CountDownLatch(numberOfServices);
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        latch.await();

        System.out.println("Main");
        executorService.shutdown();
    }

}
class DependentService1 implements Runnable {

    private final CountDownLatch latch;

    public DependentService1(CountDownLatch latch){
        this.latch=latch;
    }
    @Override
    public void run() {

    }
}

