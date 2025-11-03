package week08;

public class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Payment made via Bank Transfer.");
        isPaidOff = true;
    }

    @Override
    public double getRemainingAmount() {
        if (isPaidOff) return 0;
        else return amount;
    }
}
