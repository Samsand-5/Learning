package MultiThreading.Locks;

public class BankAccount {

    private int balance=100;

    public synchronized void withDraw(int amount){
        System.out.println(Thread.currentThread().getName()+
                " withdraw "+amount);
        if(balance>=amount){
            System.out.println(Thread.currentThread().getName()+
                    " proceeding withdraw");
            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            balance-=amount;
            System.out.println(Thread.currentThread().getName()+
                    " completed withDrawl, Remaining balance: "+balance);
        }
        else{
            System.out.println(Thread.currentThread().getName()+
                    " insufficient balance");
        }
    }
}
