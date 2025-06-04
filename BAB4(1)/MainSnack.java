/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB4;
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

        // Menampilkan daftar snack lokal
        System.out.println("=== Daftar Snack Lokal ===");
        for (int i = 0; i < snackLokal.length; i++) {
            System.out.printf("%d. %s (%s) - Rp%d [%d tersedia]%n", i + 1,
                snackLokal[i].getNama(), snackLokal[i].getRasa(),
                snackLokal[i].getHarga(), snackLokal[i].getStok());
        }

        // Menampilkan daftar snack import
        System.out.println("\n=== Daftar Snack Import ===");
        for (int i = 0; i < snackImport.length; i++) {
            System.out.printf("%d. %s (%s) - Rp%d [%d tersedia]%n", i + 1,
                snackImport[i].getNama(), snackImport[i].getAsal(),
                snackImport[i].getHarga(), snackImport[i].getStok());
        }

        // Input pilihan kategori snack dari pengguna
        System.out.println("\nPilih kategori snack:");
        System.out.println("1. Lokal");
        System.out.println("2. Import");
        System.out.print("Pilihan (1/2): ");
        int kategori = input.nextInt();

        // Input pilihan snack
        System.out.print("Pilih nomor snack: ");
        int pilih = input.nextInt();

        // Input jumlah yang ingin dibeli
        System.out.print("Jumlah beli: ");
        int jumlahBeli = input.nextInt();

        // Input penggunaan promo
        System.out.print("Gunakan promo? (true/false): ");
        boolean pakaiPromo = input.nextBoolean();

        // Input tipe pembeli (member atau umum)
        System.out.println("Tipe pembeli: ");
        System.out.println("1. Member");
        System.out.println("2. Umum");
        System.out.print("Pilihan (1/2): ");
        int tipePembeli = input.nextInt();

        int total = 0;  // Menyimpan total pembayaran
        boolean transaksiBerhasil = false;  // Status transaksi

        // Proses transaksi untuk snack lokal
        if (kategori == 1 && pilih >= 1 && pilih <= snackLokal.length) {
            SnackLocal snack = snackLokal[pilih - 1];

            // Cek apakah stok mencukupi
            if (jumlahBeli > snack.getStok()) {
                System.out.println("Stok tidak mencukupi.");
                return;
            }

            // Hitung total harga
            total = snack.getHarga() * jumlahBeli;
            if (pakaiPromo) total *= 0.8;        // Promo 20%
            if (tipePembeli == 1) total *= 0.9;   // Diskon member 10%

            // Kurangi stok setelah pembelian
            snack.setStok(snack.getStok() - jumlahBeli);
            transaksiBerhasil = true;
        }

        // Proses transaksi untuk snack import
        else if (kategori == 2 && pilih >= 1 && pilih <= snackImport.length) {
            SnackImport snack = snackImport[pilih - 1];

            // Cek stok
            if (jumlahBeli > snack.getStok()) {
                System.out.println("Stok tidak mencukupi.");
                return;
            }

            // Hitung total harga
            total = snack.getHarga() * jumlahBeli;
            if (pakaiPromo) total *= 0.8;
            if (tipePembeli == 1) total *= 0.9;

            // Update stok
            snack.setStok(snack.getStok() - jumlahBeli);
            transaksiBerhasil = true;
        }

        // Jika input tidak sesuai
        else {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        // Cetak hasil transaksi
        if (transaksiBerhasil) {
            System.out.println("Pembelian berhasil!");
            System.out.println("Total Bayar : Rp" + total);
        } else {
            System.out.println("Pembelian gagal.");
        }
    }
}