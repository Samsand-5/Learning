package MultiThreading.VolatileAndAtomic;

import java.util.concurrent.atomic.AtomicInteger;

//Use atomic classes when you need both atomicity and visibility for compound operations, like counters or conditional updates.
public class VolatileCounter {

    private AtomicInteger  counter=new AtomicInteger(0);

    public void increment(){
        counter.incrementAndGet();
    }

    public int getCounter(){
        return counter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileCounter vc=new VolatileCounter();
        Thread t1=new Thread(() ->{
            for(int i=0;i<1000;i++){
                vc.increment();
            }
        });

        Thread t2=new Thread(() ->{
            for(int i=0;i<1000;i++){
                vc.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(vc.getCounter());
    }
}
