/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB3;

/**
 *
 * @author joy
 */
// Kelas induk yang menyimpan data dan fungsi dasar untuk semua jenis snack.
public class SnackStore {
    // Atribut yang menyimpan nama snack, misalnya: "Choco Crunch", "Cheese Stick"
    protected String namaSnack;
    // Atribut yang menyimpan harga satuan per item snack
    protected double hargaPerItem;
    // Atribut yang menyimpan jumlah stok yang tersedia di toko
    protected int stok;

    // Konstruktor: Digunakan saat pertama kali membuat objek snack baru.
    // Parameter ini akan mengisi nama snack, harganya, dan stok awalnya.
    public SnackStore(String namaSnack, double hargaPerItem, int stok) {
        this.namaSnack = namaSnack;
        this.hargaPerItem = hargaPerItem;
        this.stok = stok;
    }

    // Metode untuk menghitung total harga berdasarkan jumlah beli.
    // Jika promo diaktifkan, maka total harga akan dipotong 20%.
    protected double hitungTotalHarga(int jumlah, boolean promo) {
        double total = hargaPerItem * jumlah;  // Hitung total tanpa diskon
        if (promo) total *= 0.8;               // Jika promo, potong 20%
        return total;
    }

    // Metode untuk mengurangi stok setelah pembelian berhasil dilakukan.
    protected void kurangiStok(int jumlah) {
        this.stok -= jumlah;
    }

    // Metode untuk menampilkan informasi umum dari snack:
    // Nama, harga per item, dan jumlah stok yang tersedia.
    // Ini digunakan untuk ditampilkan ke pengguna.
    protected String tampilkanDetailUmum() {
        return "Snack         : " + namaSnack + 
               "\nHarga/item  : Rp " + hargaPerItem + 
               "\nStok        : " + stok + " pcs";
    }
}
