package week08;

public class CreditCardPayment extends Payment {
    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Payment made using Credit Card.");
        isPaidOff = true;
    }

    @Override
    public double getRemainingAmount() {
        if (isPaidOff) return 0;
        else return amount;
    }
}
