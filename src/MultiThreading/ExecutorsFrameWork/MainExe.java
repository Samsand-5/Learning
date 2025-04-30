package MultiThreading.ExecutorsFrameWork;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainExe {

    public static void main(String[] args) {
        ExecutorService executor=Executors.newFixedThreadPool(9);
        for(int i=1;i<10;i++) {
            int finalI = i;
            executor.submit(  () ->{
                long result=factorial(finalI);
                System.out.println(result);
            });
        }
        executor.shutdown();

        Executor executor1=Executors.newFixedThreadPool(9);
        for(int i=1;i<10;i++) {
            int finalI = i;
            executor1.execute(  () ->{
                long result=factorial(finalI);
                System.out.println(result);
            });
        }
    }

    private static long factorial(int finalI) {
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        long fact=1;
        for(int i=1;i<=finalI;i++){
            fact*=i;
        }
        return fact;
    }
}

