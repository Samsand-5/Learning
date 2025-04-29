package MultiThreading.ExtendingThread;

public class Main1 {
    public static void main(String[] args) {

        World1 world1=new World1();
        world1.start();
        for(int i=0;i<10000;i++){
            System.out.println("Hello");
        }
    }
}
