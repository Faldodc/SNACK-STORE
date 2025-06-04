/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB7;

/**
 *
 * @author ASUS
 */
public class SnackImport extends SnackStore{
    public SnackImport(String nama, int harga, int stok) {
        super(nama, harga, stok);
    }

    @Override
    public double hitungTotal(int jumlah, boolean promo, boolean member) {
        double total = harga * jumlah;
        if (promo) total *= 0.8;
        if (member) total *= 0.9; // Diskon tambahan untuk member
        return total;
    }

    @Override
    public String getJenis() {
        return "Import";
    }
}
