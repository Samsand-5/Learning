package MultiThreading.LambdaExpression;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LambdaExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Running Task " + taskId + " by " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}
