/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB8;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class SnackStore_Exception {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("=== SISTEM PEMBELIAN SNACK (KONSOL) ===");

            System.out.print("Masukkan nama pembeli: ");
            String nama = scanner.nextLine();

            System.out.print("Masukkan jenis pembeli (Umum/Member): ");
            String tipe = scanner.nextLine();

            System.out.print("Masukkan kategori snack (Lokal/Import): ");
            String kategori = scanner.nextLine();

            System.out.print("Masukkan nama snack: ");
            String snack = scanner.nextLine();

            System.out.print("Masukkan harga snack: ");
            double harga = Double.parseDouble(scanner.nextLine());

            System.out.print("Masukkan jumlah pembelian: ");
            int jumlah = Integer.parseInt(scanner.nextLine());

            System.out.print("Gunakan promo diskon 20%? (true/false): ");
            boolean promo = Boolean.parseBoolean(scanner.nextLine());

            // Hitung total
            double total = harga * jumlah;
            if (promo) total *= 0.8;
            if (tipe.equalsIgnoreCase("Member")) total *= 0.9;

            // Tampilkan struk
            System.out.println("\n=== STRUK PEMBELIAN ===");
            System.out.println("Nama Pembeli : " + nama);
            System.out.println("Tipe Pembeli : " + tipe);
            System.out.println("Kategori     : " + kategori);
            System.out.println("Snack        : " + snack);
            System.out.println("Harga        : Rp" + harga);
            System.out.println("Jumlah       : " + jumlah);
            System.out.println("Total Bayar  : Rp" + String.format("%,.0f", total));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Input angka tidak valid!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            System.out.println("Terima kasih telah berbelanja di Snack Store.");
        }
    }
    
}
