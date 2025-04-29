package MultiThreading.Locks;

public class Main1 {
    public static void main(String[] args) {
        BankAccount bankAccount=new BankAccount();
        Runnable task=new Runnable() {
            @Override
            public void run() {
                bankAccount.withDraw(50);
            }
        };
        Thread t1=new Thread(task,"Thread 1");
        Thread t2=new Thread(task,"Thread 2");
    }
}
