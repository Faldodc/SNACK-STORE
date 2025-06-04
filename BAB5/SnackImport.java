/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB5;

/**
 *
 * @author joy
 */
public class SnackImport extends SnackStore {
    private String asal;

    public SnackImport(String nama, int harga, int stok, String asal) {
        super(nama, harga, stok);
        this.asal = asal;
    }

    public String getAsal() {
        return asal;
    }

    // Overriding getNama
    @Override
    public String getNama() {
        return super.getNama() + " (Import)";
    }
}

