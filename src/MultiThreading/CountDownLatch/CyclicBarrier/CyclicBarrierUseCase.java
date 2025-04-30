package MultiThreading.CountDownLatch.CyclicBarrier;

import java.util.concurrent.*;

public class CyclicBarrierUseCase {

    public static void main(String[] args) throws ExecutionException,InterruptedException {
        int numberOfServices=3;

        CyclicBarrier barrier=new CyclicBarrier(numberOfServices, new Runnable() {
            @Override
            public void run() {
                System.out.println("All subsystems running...System startup complete");
            }
        });

        Thread webServerThread=new Thread(new Subsytem("Web Server",2000,barrier));
        Thread databaseThread=new Thread(new Subsytem("Database Server",4000,barrier));
        Thread cacheThread=new Thread(new Subsytem("Cache Server",1000,barrier));
        Thread messageServiceThread=new Thread(new Subsytem("Messaging Server",3500,barrier));

        webServerThread.start();
        databaseThread.start();
        cacheThread.start();
        messageServiceThread.start();
    }
}

class Subsytem implements Runnable{

    private String name;
    private int initializationTime;
    private CyclicBarrier barrier;

    public Subsytem(String name,int initializationTime,CyclicBarrier barrier){
        this.name=name;
        this.initializationTime=initializationTime;
        this.barrier=barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(name+ " initialization started");
            Thread.sleep(initializationTime);
            System.out.println(name+ " initialization completed");
            barrier.await();
        }
        catch (InterruptedException | BrokenBarrierException e){
            e.printStackTrace();
        }
    }
}