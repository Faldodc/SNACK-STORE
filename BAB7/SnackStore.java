/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB7;

/**
 *
 * @author ASUS
 */
public abstract class SnackStore {
    protected String nama;
    protected int harga;
    protected int stok;

    public SnackStore(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public int getHarga() {
        return harga;
    }

    public void kurangiStok(int jumlah) {
        if (jumlah <= stok) {
            stok -= jumlah;
        }
    }

    // Abstract method - untuk polimorfisme dinamis (Overriding)
    public abstract double hitungTotal(int jumlah, boolean promo, boolean member);

    // Method Overloading - untuk polimorfisme statis (Overloading)
    public double hitungTotal(int jumlah) {
        return harga * jumlah;
    }

    // Abstract method tambahan
    public abstract String getJenis();
}
