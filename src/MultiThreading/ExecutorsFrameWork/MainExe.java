package MultiThreading.ExecutorsFrameWork;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExe {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        ExecutorService executor=Executors.newFixedThreadPool(3);
        for(int i=1;i<10;i++) {
            int finalI = i;
            executor.submit(  () ->{
                long result=factorial(finalI);
                System.out.println(result);
            });
        }
        executor.shutdown();
        System.out.println("Total time: "+(System.currentTimeMillis()-startTime));
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

