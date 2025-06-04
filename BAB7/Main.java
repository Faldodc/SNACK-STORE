/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB7;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Deklarasi array polimorfik
        SnackStore[] daftarSnack = {
            new SnackLocal("Keripik Tempe", 5000, 10),
            new SnackImport("Choco Crunch", 8000, 15)
        };

        System.out.println("=== DAFTAR SNACK ===");
        for (int i = 0; i < daftarSnack.length; i++) {
            System.out.printf("%d. %s (%s) - Rp%d - Stok: %d\n", i+1,
                    daftarSnack[i].getNama(), daftarSnack[i].getJenis(),
                    daftarSnack[i].getHarga(), daftarSnack[i].getStok());
        }

        System.out.print("Pilih snack [1-" + daftarSnack.length + "]: ");
        int pilih = input.nextInt();

        SnackStore snack = daftarSnack[pilih - 1];

        System.out.print("Masukkan jumlah beli: ");
        int jumlah = input.nextInt();

        System.out.print("Gunakan promo? (true/false): ");
        boolean promo = input.nextBoolean();

        System.out.print("Pembeli adalah member? (true/false): ");
        boolean member = input.nextBoolean();

        if (jumlah > snack.getStok()) {
            System.out.println("❌ Stok tidak mencukupi.");
        } else {
            // Gunakan polymorphic method (override)
            double total = snack.hitungTotal(jumlah, promo, member);
            snack.kurangiStok(jumlah);

            System.out.println("\n=== STRUK PEMBELIAN ===");
            System.out.println("Nama Snack   : " + snack.getNama());
            System.out.println("Jenis        : " + snack.getJenis());
            System.out.println("Jumlah       : " + jumlah);
            System.out.println("Harga Satuan : Rp" + snack.getHarga());
            System.out.println("Total Bayar  : Rp" + String.format("%,.0f", total));
            System.out.println("Sisa Stok    : " + snack.getStok());
        }

        input.close();
    }
}
