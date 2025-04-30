package MultiThreading.ExecutorsFrameWork;

import java.util.concurrent.*;

public class Future2 {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Future<Integer> future=executorService.submit(() ->{
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e){
                System.out.println("Exception occurred! "+e);
            }
            return 42;
        });
        Integer i=null;
        try {
            i=future.get(1, TimeUnit.SECONDS);
            System.out.println(future.isDone());
            System.out.println(i);
        }
        catch (InterruptedException | ExecutionException | TimeoutException e){
            System.out.println("Exception occurred! "+ e);
        }
        executorService.shutdown();

        ExecutorService executorService1= Executors.newSingleThreadExecutor();
        Future<Integer> future1=executorService1.submit(() ->{
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e){
                System.out.println("Exception occurred! "+e);
            }
            return 42;
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            System.out.println("Exception occurred! "+e);
        }
        future1.cancel(false);//true means it will always get cancelled
        System.out.println(future1.isCancelled());
        System.out.println(future1.isDone());
        executorService1.shutdown();
    }
}
