package MultiThreading.ExecutorsFrameWork;

public class Main {
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        Thread[] threads=new Thread[9];
        for(int i=1;i<10;i++) {
            int finalI = i;
            threads[i-1]=new Thread(
                    ()->{
                        long result=factorial(finalI);
                        System.out.println(result);
                    }
            );
            threads[i-1].start();
        }

        //wait for all threads in a list to finish
        for(Thread thread : threads){
            try{
                thread.join();//causes the current thread to wait until the specified thread has finished executing
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();//restores the interrupt status
            }
        }
        System.out.println("Total time: "+(System.currentTimeMillis()-startTime));
    }

    private static long factorial(int finalI) {
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        long fact=1;
        for(int i=1;i<=finalI;i++){
            fact*=i;
        }
        return fact;
    }
}
