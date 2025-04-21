package Task28thMarch2ndOne;

public class PayPalPayment extends Payment{
    PayPalPayment(double amount, long transactionId) {
        super(amount, transactionId);
    }

    @Override
    public double processPayment() {
        double fee = getAmount() * 0.02;
        return getAmount() - fee;
    }
}
