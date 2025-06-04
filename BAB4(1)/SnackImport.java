/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB4;

/**
 *
 * @author joy
 */
// Subclass dari SnackStore, menambah atribut asal
public class SnackImport extends SnackStore {
    private String asal; // Asal snack

    // Konstruktor: inisialisasi nama, harga, stok (dari superclass) dan asal
    public SnackImport(String nama, int harga, int stok, String asal) {
        super(nama, harga, stok); // Panggil konstruktor SnackStore
        this.asal = asal;
    }

    // Getter untuk asal
    public String getAsal() {
        return asal;
    }
}


