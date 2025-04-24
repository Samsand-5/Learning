package ExceptionalHandlings.Task;

public class InsufficientFundsException extends Exception{

    private double amount;
    public InsufficientFundsException(String message,double amount){
        super("You donot have enough Bank Balance laure");
    }
}
