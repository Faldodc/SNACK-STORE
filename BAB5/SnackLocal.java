/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB5;

/**
 *
 * @author joy
 */
public class SnackLocal extends SnackStore {
    private String rasa;

    public SnackLocal(String nama, int harga, int stok, String rasa) {
        super(nama, harga, stok);
        this.rasa = rasa;
    }

    public String getRasa() {
        return rasa;
    }

    // Overriding getNama
    @Override
    public String getNama() {
        return super.getNama() + " (Lokal)";
    }
}

