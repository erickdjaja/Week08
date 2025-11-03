package Assignment;

import java.util.Scanner;

public class Cash extends Payment {
    public Cash(Item item) {
        super(item);
    }

    @Override
    public void pay() {
        Scanner input = new Scanner(System.in);
        System.out.println("Bayar (Y/N): ");
        char choice = input.next().toUpperCase().charAt(0);

        if (choice == 'Y') {
            System.out.println("Harga Pembayaran : " + (int)item.getPrice());
            System.out.println("Transaksi telah dibayar lunas");
            isPaidOff = true;
        } else {
            System.out.println("Transaksi telah disimpan");
        }
    }

    @Override
    public double getRemainingAmount() {
        return isPaidOff ? 0 : item.getPrice();
    }
}
