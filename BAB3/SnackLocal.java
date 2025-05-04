/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB3;

/**
 *
 * @author joy
 */
// Kelas SnackLocal adalah turunan dari kelas SnackStore
public class SnackLocal extends SnackStore {
    
    // Atribut khusus untuk menyimpan rasa khas dari snack lokal
    String rasaKhas;

    // Konstruktor untuk menginisialisasi data snack lokal
    // Memanggil konstruktor superclass untuk nama, harga, dan stok
    // serta mengisi nilai rasa khas
    public SnackLocal(String namaSnack, double hargaPerItem, int stok, String rasaKhas) {
        super(namaSnack, hargaPerItem, stok);
        this.rasaKhas = rasaKhas;
    }

    // Method khusus untuk menampilkan informasi tambahan berupa rasa khas
    public String tampilkanKhusus() {
        return "Rasa Khas   : " + rasaKhas;
    }
}
