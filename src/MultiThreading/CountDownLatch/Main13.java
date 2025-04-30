package MultiThreading.CountDownLatch;

import java.util.concurrent.*;

public class Main13 {
    public static void main(String[] args) throws ExecutionException,InterruptedException {
        int numberOfServices=3;
        ExecutorService executorService= Executors.newFixedThreadPool(numberOfServices);
        CountDownLatch latch=new CountDownLatch(numberOfServices);
    }

}
class DependentService implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" Service started");
        Thread.sleep(2000);
        return "ok";
    }
}
