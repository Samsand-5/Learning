package MultiThreading.ExecutorsFrameWork;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Future2 {
    public static void main(String[] args) {

        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Future<Integer> future=executorService.submit(() ->42);
        Integer i=null;
        try {
            i=future.get();
            System.out.println(i);
        }
        catch (InterruptedException | ExecutionException e){
            System.out.println("Exception occurred! "+ e);
        }
    }
}
