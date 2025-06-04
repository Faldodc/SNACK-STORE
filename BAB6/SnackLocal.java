/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB6;

/**
 *
 * @author joy
 */
public class SnackLocal extends SnackStore {

    public SnackLocal(String nama, int harga, int stok) {
        super(nama, harga, stok);
    }

    @Override
    public String getJenis() {
        return "Lokal";
    }

    @Override
    public double hitungTotal(int jumlah, boolean promo, boolean member) {
        double total = harga * jumlah;
        if (promo) total *= 0.8; // diskon 20%
        return total;
    }
}
