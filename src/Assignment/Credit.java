package Assignment;

import java.util.Scanner;

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
        Scanner input = new Scanner(System.in);
        double installmentAmount = item.getPrice() / maxInstallmentAmount;

        installment++;
        System.out.println("Harga Pembayaran : " + (int)installmentAmount);
        System.out.println("Transaksi telah dibayar");

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
