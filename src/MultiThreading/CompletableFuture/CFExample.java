package MultiThreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

//CompletableFuture is used to run asynchronous tasks

public class CFExample {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture=CompletableFuture.supplyAsync(() ->{
           try{
               Thread.sleep(5000);
               System.out.println("worker");
           }
           catch (Exception e){

           }
           return "ok";
        });
        String s= null;
//        try {
//            s = completableFuture.get();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
        s=completableFuture.getNow("noo");
        System.out.println(s);
        System.out.println("Main");
    }
}
