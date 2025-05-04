/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB3;

/**
 *
 * @author joy
 */
// Kelas SnackImport adalah turunan dari kelas SnackStore
public class SnackImport extends SnackStore {

    // Atribut khusus untuk menyimpan negara asal dari snack impor
    String negaraAsal;

    // Konstruktor untuk inisialisasi data snack impor
    // Memanggil konstruktor superclass (SnackStore) dan mengisi atribut negaraAsal
    public SnackImport(String namaSnack, double hargaPerItem, int stok, String negaraAsal) {
        super(namaSnack, hargaPerItem, stok);
        this.negaraAsal = negaraAsal;
    }

    // Method khusus untuk menampilkan informasi tambahan tentang negara asal
    public String tampilkanKhusus() {
        return "Asal Negara : " + negaraAsal;
    }
}
