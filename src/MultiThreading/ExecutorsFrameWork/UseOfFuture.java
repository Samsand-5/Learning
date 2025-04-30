package MultiThreading.ExecutorsFrameWork;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UseOfFuture {
    public static void main(String[] args) throws ExecutionException,InterruptedException {
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Future<Integer> future=executorService.submit(() ->42);
        System.out.println(future.get());
        executorService.shutdown();
    }
}
