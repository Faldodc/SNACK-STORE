/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB5;

/**
 *
 * @author joy
 */
public class SnackStore {
    private String nama;
    private int harga;
    private int stok;

    public SnackStore(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    // Overloading method
    public void kurangiStok(int jumlah) {
        if (jumlah <= stok) {
            stok -= jumlah;
        }
    }

    public void kurangiStok() {
        if (stok > 0) {
            stok--;
        }
    }
}

