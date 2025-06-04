/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB4;

/**
 *
 * @author joy
 */
// Class turunan dari SnackStore dengan tambahan atribut rasa
public class SnackLocal extends SnackStore {
    private String rasa; // Rasa dari snack lokal

    // Konstruktor: memanggil konstruktor induk dan inisialisasi rasa
    public SnackLocal(String nama, int harga, int stok, String rasa) {
        super(nama, harga, stok);
        this.rasa = rasa;
    }

    // Getter untuk rasa
    public String getRasa() {
        return rasa;
    }
}


