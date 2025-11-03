package Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Payment> payments = new ArrayList<>();

        items.add(new Item(1, "Kulkas", "Electronic", 4800000));
        items.add(new Item(2, "TV", "Electronic", 1280000));
        items.add(new Item(3, "Laptop", "Computer", 6000000));
        items.add(new Item(4, "PC", "Computer", 12000000));

        while (true) {
            System.out.println("---Program Toko Elektronik----");
            System.out.println("1. Pesan Barang");
            System.out.println("2. Lihat Pesanan");
            System.out.println("3. Keluar");
            System.out.print("Pilihan : ");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.println("----Daftar Barang----");
                for (Item i : items) i.display();

                System.out.print("Pilih : ");
                int id = input.nextInt();
                if (id < 1 || id > items.size()) continue;

                Item selected = items.get(id - 1);
                System.out.println("Nama : " + selected.getName());
                System.out.println("Tipe : " + selected.getType());
                System.out.println("Harga : " + (int)selected.getPrice());
                System.out.println("----Tipe pembayaran----");
                System.out.println("1. Cash");
                System.out.println("2. Credit");
                System.out.print("Pilih : ");
                int type = input.nextInt();

                if (type == 1) {
                    Payment pay = new Cash(selected);
                    pay.pay();
                    payments.add(pay);
                } else if (type == 2) {
                    System.out.print("Lama Cicilan (3/6/9/12): ");
                    int month = input.nextInt();
                    Payment pay = new Credit(selected, month);
                    pay.pay();
                    payments.add(pay);
                }
            }

            else if (choice == 2) {
                System.out.println("---Daftar Pesanan---");
                int index = 1;
                for (Payment p : payments) {
                    Item item = p.item;
                    System.out.println("No\t\t: " + index++);
                    System.out.println("Nama\t: " + item.getName());
                    System.out.println("Tipe\t: " + item.getType());
                    System.out.println("Status\t: " + (p.isPaidOff() ? "FINISHED" : "ON PROGRESS"));
                    System.out.println("Sisa Pembayaran\t: " + (int)p.getRemainingAmount());
                    System.out.println("--------------------------------");
                }

                System.out.print("Pilih No Transaksi : ");
                int idx = input.nextInt();
                if (idx < 1 || idx > payments.size()) continue;

                Payment selected = payments.get(idx - 1);
                Item i = selected.item;
                System.out.println("Nama : " + i.getName());
                System.out.println("Tipe : " + i.getType());
                System.out.println("Harga Pembayaran : " + (int)i.getPrice());
                selected.pay();
            }

            else if (choice == 3) {
                System.out.println("Terima kasih telah menggunakan program ini.");
                break;
            }
        }

        input.close();
    }
}
