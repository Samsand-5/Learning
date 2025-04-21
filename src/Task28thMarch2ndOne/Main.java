package Task28thMarch2ndOne;

public class Main {
    public static void main(String[] args) {

        Payment payMoney1=new CreditCardPayment(300.00,1);
        System.out.println("Credit Card " + payMoney1.processPayment());

        Payment payMoney2=new PayPalPayment(300.00,2);
        System.out.println("Credit Card " + payMoney2.processPayment());
    }
}
