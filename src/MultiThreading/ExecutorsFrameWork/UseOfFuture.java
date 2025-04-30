package MultiThreading.ExecutorsFrameWork;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class UseOfFuture {
    public static void main(String[] args) throws ExecutionException,InterruptedException {

        //Use Callable when task needs to return something
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> callable = () -> "Hello Callable";
        Future<String> future = executorService.submit(callable);
        System.out.println(future.get());
        executorService.shutdown();

        //Use runnable when task doesn't to return something
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        Runnable runnable = () -> System.out.println("Hello Runnable");
        Future<?> future1 = executorService1.submit(runnable);
        System.out.println(future1.get());
        executorService1.shutdown();

        //Normal its Runnable only
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        Future<?> future2 = executorService2.submit(() -> System.out.println("Hello Normal"));
        System.out.println(future2.get());
        executorService2.shutdown();

        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        Future<?> future3 = executorService3.submit(() -> System.out.println("Hello Normal"));
        future3.get();
        executorService2.shutdown();
        Future<String> submit = executorService3.submit(() -> System.out.println("Hello"), "success");

        ExecutorService executorService4=Executors.newFixedThreadPool(2);
        Future<Integer> submit1=executorService4.submit(() ->1+2);
        Integer i=submit1.get();
        System.out.println("sum is "+i);
        executorService4.shutdown();
        Thread.sleep(1);
        System.out.println(executorService4.isTerminated());

        ExecutorService executorService5=Executors.newFixedThreadPool(2);

        Callable<Integer> callable1=()->{
            System.out.println("Task 1");
            return 1;
        };
        Callable<Integer> callable2=()->{
            System.out.println("Task 2");
            return 2;
        };
        Callable<Integer> callable3=()->{
            System.out.println("Task 3");
            return 3;
        };

        List<Callable<Integer>> list=Arrays.asList(callable1,callable2,callable3);

        List<Future<Integer>> futures=executorService5.invokeAll(list);
        for(Future<Integer> f: futures){
            System.out.println(f.get());
        }
        executorService5.shutdown();
        System.out.println("Hello World!");
    }
}
