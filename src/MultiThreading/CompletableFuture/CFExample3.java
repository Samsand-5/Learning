package MultiThreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class CFExample3 {
    public static void main(String[] args) {
        CompletableFuture<String> f = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("worker");
            } catch (Exception e) {

            }
            return "ok";
        });
    }
}
