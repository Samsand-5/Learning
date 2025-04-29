package MultiThreading.Locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance=100;

    private final Lock lock=new ReentrantLock();

    public void withDraw(int amount){
        System.out.println(Thread.currentThread().getName()+
                " withdraw "+amount);
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if(balance>=amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() +
                                " proceeding withdraw");
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() +
                                " completed withDrawl, Remaining balance: " + balance);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    finally {

                    }
                }
                else{
                    System.out.println(Thread.currentThread().getName()+
                            " insufficient balance");
                }
            }
        }catch (Exception e){

        }
    }
}
