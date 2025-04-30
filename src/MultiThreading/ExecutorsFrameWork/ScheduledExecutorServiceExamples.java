package MultiThreading.ExecutorsFrameWork;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExamples {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(
                () -> System.out.println("Task executed in 5 second delay"),
                5,
                TimeUnit.SECONDS);
        scheduler.shutdown();

        ScheduledExecutorService scheduler1 = Executors.newScheduledThreadPool(1);
        scheduler1.scheduleAtFixedRate(
                () -> System.out.println("Task executed after every 5 second delay"),
                5,
                5,
                TimeUnit.SECONDS);

        scheduler1.scheduleWithFixedDelay(() ->
                        System.out.println("Task executed after every 5 seconds"),
                5,
                5,
                TimeUnit.SECONDS);


        scheduler1.schedule(() ->{
            System.out.println("Initiating shutdown....");
            scheduler1.shutdown();
        },20, TimeUnit.SECONDS);

    }
}
