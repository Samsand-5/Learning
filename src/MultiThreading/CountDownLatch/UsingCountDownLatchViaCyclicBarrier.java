package MultiThreading.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingCountDownLatchViaCyclicBarrier {
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
