package MultiThreading.LambdaExpression;

public class SharedCounterExample {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        SharedCounterExample counter = new SharedCounterExample();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final Count: " + counter.count);
    }
}

