package MultiThreading.LambdaExpression;

public class MultipleLambdaThreadsExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            int taskId = i;
            new Thread(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
            }).start();
        }
    }
}
