/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB1;
import java.util.Scanner;
/**
 *
 * @author joy
 */
// Class Snack dengan atribut dan method sederhana
public class SnackStore {
    // Atribut snack
    String namaSnack;
    double hargaPerItem;
    int stok;

    // Method untuk menghitung total harga berdasarkan jumlah item
    double hitungTotalHarga(int jumlah) {
        return hargaPerItem * jumlah;
    }

    // Method untuk menampilkan detail snack
    void tampilkanDetail() {
        System.out.println("Nama Snack: " + namaSnack);
        System.out.println("Harga per Item: Rp" + hargaPerItem);
        System.out.println("Stok Tersedia: " + stok + " pcs");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat objek snack
        SnackStore snack1 = new SnackStore();
        snack1.namaSnack = "Choco Crunch";
        snack1.hargaPerItem = 8000;
        snack1.stok = 20;

        SnackStore snack2 = new SnackStore();
        snack2.namaSnack = "Cheese Stick";
        snack2.hargaPerItem = 6000;
        snack2.stok = 15;

        // Menampilkan pilihan snack
        System.out.println("== Selamat Datang di Snack Store ==");
        System.out.println("Pilih snack yang ingin dibeli:");
        System.out.println("1. " + snack1.namaSnack + " (Rp" + snack1.hargaPerItem + ")");
        System.out.println("2. " + snack2.namaSnack + " (Rp" + snack2.hargaPerItem + ")");

        // Input pilihan user
        System.out.print("Masukkan pilihan (1-2): ");
        int pilihan = scanner.nextInt();

        SnackStore snackDipilih = null;

        if (pilihan == 1) {
            snackDipilih = snack1;
        } else if (pilihan == 2) {
            snackDipilih = snack2;
        } else {
            System.out.println("Pilihan tidak valid!");
            System.exit(0);
        }

        // Menampilkan detail snack
        System.out.println("\nDetail Produk:");
        snackDipilih.tampilkanDetail();

        // Input jumlah item yang ingin dibeli
        System.out.print("\nMasukkan jumlah item yang ingin dibeli: ");
        int jumlah = scanner.nextInt();

        if (jumlah > snackDipilih.stok) {
            System.out.println("Stok tidak mencukupi! Hanya tersedia " + snackDipilih.stok + " pcs.");
        } else {
            double total = snackDipilih.hitungTotalHarga(jumlah);
            System.out.println("Total Harga: Rp" + total);

            // Konfirmasi pembelian
            System.out.print("Lanjutkan pembelian? (ya/tidak): ");
            String konfirmasi = scanner.next().toLowerCase();

            if (konfirmasi.equals("ya")) {
                snackDipilih.stok -= jumlah;
                System.out.println("\nPembelian Berhasil! Terima kasih telah berbelanja.");
                System.out.println("Sisa Stok: " + snackDipilih.stok + " pcs");
            } else {
                System.out.println("\nPembelian Dibatalkan.");
            }
        }

        scanner.close();
    }
}
