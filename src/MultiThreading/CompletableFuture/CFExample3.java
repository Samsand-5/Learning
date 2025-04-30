package MultiThreading.CompletableFuture;

import java.util.concurrent.*;

public class CFExample3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try {
            String ff = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println("worker");
                } catch (Exception e) {

                }
                return "ok";
            }).get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main");

        CompletableFuture<String> ff1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("worker");
            } catch (Exception e) {

            }
            return "ok";
        }).thenApply(x->x+x);
        System.out.println(ff1.get());

        CompletableFuture<String> ff2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("worker");
            } catch (Exception e) {

            }
            return "ok";
        }).orTimeout(1, TimeUnit.SECONDS).exceptionally(s->"Timeout occured");
        System.out.println(ff2.get());

        //Controlling thread type by providing custom executor service
        //Basically it often runs on daemon threads
        Executor executor =Executors.newFixedThreadPool(3);
        CompletableFuture<String> ff3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("worker");
            } catch (Exception e) {

            }
            return "ok";
        },executor).orTimeout(1, TimeUnit.SECONDS).exceptionally(s->"Timeout occured");
        System.out.println(ff3.get());
    }
}
