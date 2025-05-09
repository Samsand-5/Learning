package MultiThreading.VolatileAndAtomic;


class SharedObj{

    private volatile boolean flag=false;

    public void setFlagTrue(){
        System.out.println("Writer thread made flag true");
        flag=true;
    }

    public void printIfFlagTrue(){
        while(!flag){

        }
        System.out.println("Flag is true");
    }
}

//Use volatile when you only need to ensure visibility for single-read and single-write operations.
public class VolatileExample {
    public static void main(String[] args) {
        SharedObj sharedObj=new SharedObj();

        Thread writerThread=new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            sharedObj.setFlagTrue();
        });

        Thread readerThread=new Thread(()->{
            sharedObj.printIfFlagTrue();
        });

        writerThread.start();
        readerThread.start();
    }
}
