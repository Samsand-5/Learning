package MultiThreading.Locks;

public class BankAccount {

    private int balance=0;

    public void withDraw(int amount){
        System.out.println(Thread.currentThread().getName()+" withdraw "+amount);
        if(balance>=amount){
            System.out.println(Thread.currentThread().getName()+" proceeding withdraw");
            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            balance-=amount;
            System.out.println(Thread.currentThread().getName()+" completed withDrawl, Remaining balnce: "+balance);
        }
        else{
            System.out.println(Thread.currentThread().getName()+" insufficient balance");
        }
    }
}
