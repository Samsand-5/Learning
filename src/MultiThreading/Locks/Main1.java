package MultiThreading.Locks;

public class Main1 {
    public static void main(String[] args) {
        BankAccount hdfc=new BankAccount();
        Runnable task=new Runnable() {
            @Override
            public void run() {
                hdfc.withDraw(50);
            }
        };
        Thread t1=new Thread(task,"Thread 1");
        Thread t2=new Thread(task,"Thread 2");

        t1.start();
        t2.start();
    }
}
