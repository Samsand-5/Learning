package MultiThreadingPractice;

public class Main {

    // public static class ChildThreadTask implements Runnable {
    //     @Override
    //     public void run() {
    //         count();
    //     }
    // }

    public static void main(String[] args) {
        // System.out.println(Thread.currentThread().getName());
        Thread childThread=new Thread(() -> count(),"child");
        childThread.start();
        count();
    }

    public static void count() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+ " : "+i);
        }
    }
}