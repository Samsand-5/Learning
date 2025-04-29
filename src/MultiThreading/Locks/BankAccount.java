package MultiThreading.Locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance=100;

    private final Lock lock=new ReentrantLock();

    public void withDraw(int amount){
        System.out.println(Thread.currentThread().getName()+
                " atempting withdraw "+amount);
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if(balance>=amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() +
                                " proceeding withdraw");
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() +
                                " completed withdrawal, Remaining balance: " + balance);
                    }
                    catch (Exception e){
                    }
                    finally {
                        lock.unlock();
                    }
                }
                else{
                    System.out.println(Thread.currentThread().getName()+
                            " insufficient balance");
                }
            }
            else{
                System.out.println(Thread.currentThread().getName()+" couldn't acquire the lock,will try later");
            }
        }
        catch (Exception e){
        }
    }
}
