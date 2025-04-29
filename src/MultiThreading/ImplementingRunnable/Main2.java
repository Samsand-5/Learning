package MultiThreading.ImplementingRunnable;

import MultiThreading.ExtendingThread.World1;

public class Main2 {

    public static void main(String[] args) {

        World2 world2=new World2();// New
        Thread t2=new Thread(world2);// Runnable
        t2.start();

        for(int i=0;i<10000;i++){
            System.out.println("Hello");
        }
    }
}
