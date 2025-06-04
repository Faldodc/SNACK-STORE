/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB9;

/**
 *
 * @author ASUS
 */
public class SnackImport implements SnackStore {
    private String nama;
    private double harga;
    private int stok;

    // Konstruktor tanpa pajak
    public SnackImport(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Implementasi interface SnackStore
    @Override
    public String getNama() {
        return nama;
    }

    @Override
    public double getHarga() {
        return harga;
    }

    @Override
    public double hitungTotal(int jumlah) {
        return harga * jumlah;
    }

    @Override
    public String getJenis() {
        return "Snack Import";
    }

    // Method tambahan
    public int getStok() {
        return stok;
    }

    public void kurangiStok(int jumlah) {
        if (jumlah <= stok) {
            this.stok -= jumlah;
        } else {
            throw new IllegalArgumentException("Stok tidak mencukupi!");
        }
    }
}