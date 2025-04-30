package MultiThreading.CountDownLatch;

import java.util.concurrent.*;

public class Main13 {
    public static void main(String[] args) throws ExecutionException,InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        Future<String> future1=executorService.submit(new DependentService());
        Future<String> future2=executorService.submit(new DependentService());
        Future<String> future3=executorService.submit(new DependentService());

        future1.get();
        future2.get();
        future3.get();

        System.out.println("All dependent services finished!!,Starting Main Service.....");
        executorService.shutdown();
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
