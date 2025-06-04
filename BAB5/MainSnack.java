/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB5;
import java.util.Scanner;
/**
 *
 * @author joy
 */
public class MainSnack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Inisialisasi array snack lokal
        SnackLocal[] snackLokal = {
            new SnackLocal("Cheese Stick", 6000, 20, "Balado"),
            new SnackLocal("Taro Chips", 7000, 15, "Rumput Laut"),
            new SnackLocal("Singkong Crispy", 5000, 10, "Pedas Manis"),
            new SnackLocal("Keripik Tempe", 4000, 25, "Original"),
            new SnackLocal("Keripik Pisang", 5500, 18, "Cokelat")
        };

        // Inisialisasi array snack import
        SnackImport[] snackImport = {
            new SnackImport("Choco Crunch", 8000, 15, "Jepang"),
            new SnackImport("Matcha Wafer", 9500, 10, "Korea"),
            new SnackImport("Nori Stick", 10000, 8, "Thailand"),
            new SnackImport("Pocky Strawberry", 12000, 14, "Jepang"),
            new SnackImport("Kinder Bueno", 13000, 9, "Jerman")
        };

        // Tampilkan snack lokal
        System.out.println("=== Daftar Snack Lokal ===");
        for (int i = 0; i < snackLokal.length; i++) {
            System.out.printf("%d. %s - Rp%d (%d tersedia)%n", i + 1,
                    snackLokal[i].getNama(), snackLokal[i].getHarga(), snackLokal[i].getStok());
        }

        // Tampilkan snack import
        System.out.println("\n=== Daftar Snack Import ===");
        for (int i = 0; i < snackImport.length; i++) {
            System.out.printf("%d. %s - Rp%d (%d tersedia)%n", i + 1,
                    snackImport[i].getNama(), snackImport[i].getHarga(), snackImport[i].getStok());
        }

        // Pilihan kategori
        System.out.println("\nPilih kategori snack:");
        System.out.println("1. Lokal");
        System.out.println("2. Import");
        System.out.print("Pilihan (1/2): ");
        int kategori = input.nextInt();

        System.out.print("Pilih nomor snack: ");
        int pilih = input.nextInt();

        System.out.print("Jumlah beli: ");
        int jumlah = input.nextInt();

        int total = 0;

        if (kategori == 1 && pilih >= 1 && pilih <= snackLokal.length) {
            SnackLocal snack = snackLokal[pilih - 1];
            if (jumlah <= snack.getStok()) {
                snack.kurangiStok(jumlah); // Overloading method digunakan
                total = snack.getHarga() * jumlah;
                System.out.println("Total bayar: Rp" + total);
            } else {
                System.out.println("Stok tidak cukup.");
            }
        } else if (kategori == 2 && pilih >= 1 && pilih <= snackImport.length) {
            SnackImport snack = snackImport[pilih - 1];
            if (jumlah <= snack.getStok()) {
                snack.kurangiStok(); // Overloading method tanpa parameter
                total = snack.getHarga() * jumlah;
                System.out.println("Total bayar: Rp" + total);
            } else {
                System.out.println("Stok tidak cukup.");
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }
}

