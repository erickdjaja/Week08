package week08;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Laptop", 10000000));
        items.add(new Item("Smartphone", 5000000));
        items.add(new Item("Headphone", 1500000));

        Scanner input = new Scanner(System.in);
        System.out.println("=== Menu Pembelian Elektronik ===");
        System.out.println("1. Lihat Barang");
        System.out.println("2. Beli Barang");
        System.out.print("Pilih menu: ");
        int choice = input.nextInt();

        if (choice == 1) {
            for (Item i : items) {
                System.out.println(i.getName() + " - Rp" + i.getPrice());
            }
        } else if (choice == 2) {
            System.out.println("Pilih barang (0 untuk batal): ");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i).getName());
            }

            int selection = input.nextInt() - 1;
            if (selection < 0 || selection >= items.size()) {
                System.out.println("Pilihan tidak valid.");
                return;
            }

            Item selectedItem = items.get(selection);
            System.out.println("Pilih metode pembayaran:");
            System.out.println("1. Cash");
            System.out.println("2. Credit");
            int method = input.nextInt();

            Payment payment;
            if (method == 1) {
                payment = new Cash(selectedItem);
            } else {
                System.out.print("Masukkan jumlah cicilan: ");
                int maxInstallment = input.nextInt();
                payment = new Credit(selectedItem, maxInstallment);
            }

            while (!payment.isPaidOff) {
                payment.pay();
                System.out.println("Sisa pembayaran: " + payment.getRemainingAmount());
            }

            System.out.println("Pembayaran untuk " + selectedItem.getName() + " selesai!");
        }

        input.close();
    }
}
