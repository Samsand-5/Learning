package MultiThreading.ExecutorsFrameWork;

import java.util.concurrent.*;

public class MainExe {

    public static void main(String[] args) {
//        Executor executor1=Executors.newFixedThreadPool(9);
//        for(int i=1;i<10;i++) {
//            int finalI = i;
//            executor1.execute(  () ->{
//                long result=factorial(finalI);
//                System.out.println(result);
//            });
//        }


        ExecutorService executor=Executors.newFixedThreadPool(9);
        for(int i=1;i<10;i++) {
            int finalI = i;
            Future<?>future = executor.submit(  () ->{
                long result=factorial(finalI);
                System.out.println(result);
            });
        }
        executor.shutdown();
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

