package MultiThreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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
    }
}
