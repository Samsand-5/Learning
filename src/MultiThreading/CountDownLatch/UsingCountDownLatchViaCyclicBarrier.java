package MultiThreading.CountDownLatch;

import java.util.concurrent.*;

public class UsingCountDownLatchViaCyclicBarrier {
    public static void main(String[] args) throws ExecutionException,InterruptedException {
        int numberOfServices=3;
        ExecutorService executorService= Executors.newFixedThreadPool(numberOfServices);
        CyclicBarrier barrier=new CyclicBarrier(numberOfServices);
        executorService.submit(new DependentService3(barrier));
        executorService.submit(new DependentService3(barrier));
        executorService.submit(new DependentService3(barrier));


        System.out.println("Main");
        executorService.shutdown();
    }
}

class DependentService3 implements Callable<String>{

    private final CyclicBarrier barrier;

    public DependentService3(CyclicBarrier barrier){
        this.barrier=barrier;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName()+" Service started");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+ " is waiting at barrier");
            barrier.await();
        }
        finally {
        }
        return "ok";
    }
}
