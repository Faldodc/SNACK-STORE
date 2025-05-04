/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB2;
import java.util.Scanner;
/**
 *
 * @author joy
 */
//Program sederhana untuk simulasi pemesanan snack 
//Menggunakan constructor untuk inisialisasi objek
public class SnackStore {
    // Atribut Snack
    String namaSnack;
    double hargaPerItem;
    int stok;

    // Constructor untuk menginisialisasi atribut saat objek dibuat
    public SnackStore(String nama, double harga, int stokAwal) {
        this.namaSnack = nama;
        this.hargaPerItem = harga;
        this.stok = stokAwal;
    }

    // Method untuk menghitung total harga berdasarkan jumlah pembelian
    double hitungTotalHarga(int jumlah) {
        return hargaPerItem * jumlah;
    }

    // Method untuk menampilkan informasi snack
    void tampilkanDetail() {
        System.out.println("Nama Snack: " + namaSnack);
        System.out.println("Harga per Item: Rp" + hargaPerItem);
        System.out.println("Stok Tersedia: " + stok + " pcs");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menampilkan pilihan snack
        System.out.println("=== E-Commerce Snack Store ===");
        System.out.println("Pilih snack yang ingin dibeli:");
        System.out.println("1. Choco Crunch (Rp8000)");
        System.out.println("2. Cheese Stick (Rp6000)");

        // Input pilihan user
        System.out.print("Masukkan pilihan (1-2): ");
        int pilihan = scanner.nextInt();

        // Deklarasi objek snack menggunakan konstruktor
        SnackStore snack = null;

        // Membuat objek sesuai pilihan pengguna
        if (pilihan == 1) {
            snack = new SnackStore("Choco Crunch", 8000, 20);
        } else if (pilihan == 2) {
            snack = new SnackStore("Cheese Stick", 6000, 15);
        } else {
            System.out.println("Pilihan tidak valid!");
            System.exit(0);
        }

        // Menampilkan detail snack yang dipilih
        System.out.println("\nDetail Produk Anda:");
        snack.tampilkanDetail();

        // Input jumlah pembelian
        System.out.print("\nMasukkan jumlah item yang ingin dibeli: ");
        int jumlah = scanner.nextInt();

        // Pengecekan stok
        if (jumlah > snack.stok) {
            System.out.println("Stok tidak mencukupi! Hanya tersedia " + snack.stok + " pcs.");
        } else {
            double totalHarga = snack.hitungTotalHarga(jumlah);
            System.out.println("Total Harga: Rp" + totalHarga);

            // Konfirmasi pembelian
            System.out.print("\nLanjutkan pembelian? (ya/tidak): ");
            String konfirmasi = scanner.next().toLowerCase();

            if (konfirmasi.equals("ya")) {
                snack.stok -= jumlah;
                System.out.println("\nPembelian Berhasil! Terima kasih telah berbelanja.");
                System.out.println("Sisa Stok: " + snack.stok + " pcs");
            } else {
                System.out.println("\nPembelian Dibatalkan.");
            }
        }

        // Menutup scanner
        scanner.close();
    }
}
