package ExceptionalHandlings.Task;

public class InsufficientFundsException extends Exception{

    private double amount;

    public InsufficientFundsException(double amount){
        super("You donot have enough Bank Balance laure");
        this.amount=amount;
    }

    public double getAmount(){
        return amount;
    }
}
