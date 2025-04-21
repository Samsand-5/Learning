package Task28thMarch2ndOne;

public abstract class Payment {
    private double amount;
    private long transactionId;

    Payment(double amount,long transactionId){
        this.amount=amount;
        this.transactionId=transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public abstract double processPayment();
}
