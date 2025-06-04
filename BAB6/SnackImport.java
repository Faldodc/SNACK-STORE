/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB6;

/**
 *
 * @author joy
 */
public class SnackImport extends SnackStore {

    public SnackImport(String nama, int harga, int stok) {
        super(nama, harga, stok);
    }

    @Override
    public String getJenis() {
        return "Import";
    }

    @Override
    public double hitungTotal(int jumlah, boolean promo, boolean member) {
        double total = harga * jumlah;
        if (promo) total *= 0.8;  // diskon 20%
        if (member) total *= 0.9; // diskon member 10%
        return total;
    }
}
