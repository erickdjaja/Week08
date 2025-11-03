package week08;

public class Credit extends Payment {
    private int installment;
    private int maxInstallmentAmount;

    public Credit(Item item, int maxInstallmentAmount) {
        super(item);
        this.maxInstallmentAmount = maxInstallmentAmount;
        this.installment = 0;
    }

    @Override
    public void pay() {
        double installmentAmount = item.getPrice() / maxInstallmentAmount;
        installment++;
        System.out.println("Paying installment " + installment + " of " + maxInstallmentAmount + ": " + installmentAmount);

        if (installment >= maxInstallmentAmount) {
            isPaidOff = true;
        }
    }

    @Override
    public double getRemainingAmount() {
        if (isPaidOff) return 0;
        double totalPaid = (item.getPrice() / maxInstallmentAmount) * installment;
        return item.getPrice() - totalPaid;
    }
}
