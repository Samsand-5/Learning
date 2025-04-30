package MultiThreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class CFExample2 {
    public static void main(String[] args) {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("worker");
            } catch (Exception e) {

            }
            return "ok";
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("worker");
            } catch (Exception e) {

            }
            return "ok";
        });

        CompletableFuture<Void> f = CompletableFuture.allOf(f1, f2);
        f.join();
        System.out.println("Main");
    }
}
