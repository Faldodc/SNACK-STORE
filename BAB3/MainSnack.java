/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB3;
import java.util.Scanner;
/**
 *
 * @author joy
 */
public class MainSnack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat objek snack lokal dan impor
        SnackLocal snack1 = new SnackLocal("Choco Crunch", 8000, 20, "Cokelat Manis");
        SnackImport snack2 = new SnackImport("Cheese Stick", 6000, 15, "Belanda");

        // Menampilkan pilihan snack
        System.out.println("== Selamat Datang Di Snack Store ==");
        System.out.println("Pilih Snack Yang Ingin Dibeli : ");
        System.out.println("1. " + snack1.namaSnack + " (Rp " + snack1.hargaPerItem + ")");
        System.out.println("2. " + snack2.namaSnack + " (Rp " + snack2.hargaPerItem + ")");

        // Input pilihan user
        System.out.print("Masukkan Pilihan (1 atau 2) : ");
        int pilihan = scanner.nextInt();

        SnackStore snackDipilih = null;

        if (pilihan == 1) {
            snackDipilih = snack1;
        } else if (pilihan == 2) {
            snackDipilih = snack2;
        } else {
            System.out.println("Pilihan Tidak Valid!");
            scanner.close();
            return;
        }

        // Menampilkan detail snack
        System.out.println("\nDetail Produk :");
        System.out.println(snackDipilih.tampilkanDetailUmum());
        if (snackDipilih instanceof SnackLocal) {
            System.out.println(((SnackLocal) snackDipilih).tampilkanKhusus());
        } else if (snackDipilih instanceof SnackImport) {
            System.out.println(((SnackImport) snackDipilih).tampilkanKhusus());
        }

        // Input jumlah item yang ingin dibeli
        System.out.print("\nMasukkan Jumlah Snack Yang Ingin Dibeli : ");
        int jumlah = scanner.nextInt();

        if (jumlah > snackDipilih.stok) {
            System.out.println("Stok Tidak Mencukupi! Hanya Tersedia " + snackDipilih.stok + " pcs.");
        } else {
            // Menanyakan apakah ada promo
            System.out.print("Apakah Ada Promo? (ya / tidak) : ");
            String adaPromo = scanner.next().toLowerCase();
            boolean promo = adaPromo.equals("ya");
            double total = snackDipilih.hitungTotalHarga(jumlah, promo);
            System.out.println("Total Harga : Rp " + total);

            // Konfirmasi pembelian
            System.out.print("Lanjutkan Pembelian? (ya / tidak) : ");
            String konfirmasi = scanner.next().toLowerCase();
            if (konfirmasi.equals("ya")) {
                snackDipilih.kurangiStok(jumlah);
                System.out.println("\nPembelian Berhasil! Terima Kasih Telah Belanja Di Snack Store.");
                System.out.println("Sisa Stok : " + snackDipilih.stok + " pcs");
            } else {
                System.out.println("\nPembelian Dibatalkan.");
            }
        }

        scanner.close();
    }
}
