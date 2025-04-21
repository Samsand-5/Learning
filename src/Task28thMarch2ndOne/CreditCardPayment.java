package Task28thMarch2ndOne;

public class CreditCardPayment extends Payment{

    CreditCardPayment(double amount, long transactionId) {
        super(amount, transactionId);
    }

    @Override
    public double processPayment() {
        return 0;
    }
}
