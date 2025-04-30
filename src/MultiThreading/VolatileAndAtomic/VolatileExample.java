package MultiThreading.VolatileAndAtomic;


class SharedObj{

    private boolean flag=false;

    public void setFlagTrue(){
        flag=true;
    }

    public void printIfFlagTrue(){
        while(!flag){

        }
        System.out.println("Flag is true");
    }
}
public class VolatileExample {
    public static void main(String[] args) {
        SharedObj sharedObj=new SharedObj();

        Thread writerThread=new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
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
