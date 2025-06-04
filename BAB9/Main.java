/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB9;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SnackStore snack;

        System.out.println("Pilih jenis snack: ");
        System.out.println("[1] Snack Lokal");
        System.out.println("[2] Snack Import");
        System.out.print("Pilihan: ");
        int pilihan = input.nextInt();
        input.nextLine(); // Bersihkan buffer

        System.out.print("Nama snack: ");
        String nama = input.nextLine();

        System.out.print("Harga per item: ");
        double harga = input.nextDouble();

        System.out.print("Stok tersedia: ");
        int stok = input.nextInt();

        System.out.print("Jumlah beli: ");
        int jumlah = input.nextInt();

        if (jumlah > stok) {
            System.out.println("❌ Jumlah melebihi stok yang tersedia!");
            return;
        }

        // Buat objek sesuai pilihan
        if (pilihan == 1) {
            snack = new SnackLocal(nama, harga, stok); // versi tanpa kemasanTradisional
        } else {
            snack = new SnackImport(nama, harga, stok); // versi tanpa pajak
        }

        double total = snack.hitungTotal(jumlah);

        System.out.println("\n--- RINCIAN PEMBELIAN ---");
        System.out.println("Nama Snack : " + snack.getNama());
        System.out.println("Jenis      : " + snack.getJenis());
        System.out.println("Harga/item : Rp" + snack.getHarga());
        System.out.println("Jumlah     : " + jumlah);
        System.out.println("Total Bayar: Rp" + String.format("%,.0f", total));
    }
}