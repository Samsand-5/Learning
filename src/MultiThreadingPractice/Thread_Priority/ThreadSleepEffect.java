package MultiThreadingPractice.Thread_Priority;

public class ThreadSleepEffect {
    public static void main(String[] args) {
        Thread highPriorityThread = new Thread(() -> countWithSleep(1000), "High-Priority-Thread");
        Thread lowPriorityThread = new Thread(() -> countWithSleep(0), "Low-Priority-Thread");

        highPriorityThread.setPriority(Thread.MAX_PRIORITY);//will spend more time on sleep
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);//will dominate output

        lowPriorityThread.start();
        highPriorityThread.start();
    }

    public static void countWithSleep(int sleepTime) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started counting.");

        for (int i = 0; i < 20; i++) {
            System.out.println(threadName + " count: " + i);
            // sleep logic here...
            try {
                Thread.sleep(sleepTime);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
