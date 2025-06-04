/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB4;

/**
 *
 * @author joy
 */
// Mendeklarasikan class SnackStore yang merepresentasikan sebuah objek snack/toko snack
public class SnackStore {
    // Deklarasi atribut private: nama snack, harga snack, dan jumlah stok yang tersedia
    private String nama;
    private int harga;
    private int stok;

    // Konstruktor untuk menginisialisasi objek SnackStore dengan nama, harga, dan stok
    public SnackStore(String nama, int harga, int stok) {
        this.nama = nama;     // Menetapkan nilai nama snack
        this.harga = harga;   // Menetapkan nilai harga snack
        this.stok = stok;     // Menetapkan nilai stok awal snack
    }

    // Getter untuk mendapatkan nama snack
    public String getNama() {
        return nama;
    }

    // Getter untuk mendapatkan harga snack
    public int getHarga() {
        return harga;
    }

    // Getter untuk mendapatkan jumlah stok snack saat ini
    public int getStok() {
        return stok;
    }

    // Setter untuk mengatur ulang jumlah stok snack
    public void setStok(int stok) {
        this.stok = stok;
    }

    // Method untuk mengurangi stok berdasarkan jumlah yang dibeli
    public void kurangiStok(int jumlah) {
        // Mengecek apakah jumlah yang ingin dikurangi tidak lebih dari stok yang tersedia
        if (jumlah <= stok) {
            stok -= jumlah; // Jika ya, maka stok dikurangi sesuai jumlah
        }
    }
}



