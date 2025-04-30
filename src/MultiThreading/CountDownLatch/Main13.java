package MultiThreading.CountDownLatch;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main13 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        executorService.submit(new DependentService());
        executorService.submit(new DependentService());
        executorService.submit(new DependentService());
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
