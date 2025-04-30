package MultiThreading.CountDownLatch;

import java.util.concurrent.*;

//CountDownLatch is used when we need to wait 1 or more than 1 threads to accomplish task

public class Main13 {
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
class DependentService implements Callable<String>{

    private final CountDownLatch latch;

    public DependentService(CountDownLatch latch){
        this.latch=latch;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName()+" Service started");
            Thread.sleep(2000);
        }
        finally {
            latch.countDown();
        }
        return "ok";
    }
}
