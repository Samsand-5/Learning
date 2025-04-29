package MultiThreading.Locks;

public class BankAccount {

    private int balance=0;

    public void withDraw(int amount){
        System.out.println(Thread.currentThread().getName()+" withdraw "+amount);
        if(balance>=amount){
            System.out.println(Thread.currentThread().getName()+" proceeding withdraw");
        }
        else{
            System.out.println(Thread.currentThread().getName()+" insufficient balance");
        }
    }
}
