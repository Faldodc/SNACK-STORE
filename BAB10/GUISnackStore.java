/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package BAB9_10_NEW;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joy
 */
public class GUISnackStore extends javax.swing.JFrame{

    /**
     * Creates new form GUISnackStore
     */
    public GUISnackStore() {
        initComponents();
        tampilData();
        String[] kolom = {"Nama", "Tipe Pembeli", "Snack", "Jumlah", "Harga", "Promo", "Total Bayar"};
        DefaultTableModel model = new DefaultTableModel(null, kolom);
        tabel.setModel(model);
    }
    
    

    private void tampilData() {
       DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama");
        model.addColumn("Tipe Pembeli");
        model.addColumn("Snack");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Promo");
        model.addColumn("Total Bayar");

        try (Connection conn = Koneksi.getKoneksi()) {
                String sql = "SELECT nama_pembeli, tipe_pembeli, snack, jumlah, harga, promo, total_bayar FROM tb_snackstore";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getString("nama_pembeli"),
                        rs.getString("tipe_pembeli"),
                        rs.getString("snack"),
                        rs.getInt("jumlah"),
                        rs.getDouble("harga"),
                        rs.getString("promo"),
                        rs.getDouble("total_bayar")
                    });
                }
                tabel.setModel(model);
           } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal tampil data: " + e.getMessage());
        }

    }

    private void tambahData() {
        try (Connection conn = Koneksi.getKoneksi()) {
            String sql = "INSERT INTO tb_snackstore (nama_pembeli, tipe_pembeli, snack, jumlah, harga, promo, total_bayar) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);

            String nama = txtNama.getText();
            String tipe = rbMember.isSelected() ? "Member" : "Umum";
            String snack = cmbSnack.getSelectedItem().toString();
            int jumlah = Integer.parseInt(txtJumlah.getText());
            boolean promo = cbPromo.isSelected();
            double harga = getHargaSnack(snack);
            double total = harga * jumlah;
            if (promo) total *= 0.8;
            if (tipe.equals("Member")) total *= 0.9;

            st.setString(1, nama);
            st.setString(2, tipe);
            st.setString(3, snack);
            st.setInt(4, jumlah);
            st.setDouble(5, harga);
            st.setString(6, promo ? "Ya" : "Tidak");
            st.setDouble(7, total);

            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
            tampilData();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menambah data: " + e.getMessage());
        }
    }

    private void ubahData() {
        try (Connection conn = Koneksi.getKoneksi()) {
            String sql = "UPDATE tb_snackstore SET tipe_pembeli=?, snack=?, jumlah=?, harga=?, promo=?, total_bayar=? WHERE nama_pembeli=?";
            PreparedStatement st = conn.prepareStatement(sql);

            String nama = txtNama.getText();
            String tipe = rbMember.isSelected() ? "Member" : "Umum";
            String snack = cmbSnack.getSelectedItem().toString();
            int jumlah = Integer.parseInt(txtJumlah.getText());
            boolean promo = cbPromo.isSelected();
            double harga = getHargaSnack(snack);
            double total = harga * jumlah;
            if (promo) total *= 0.8;
            if (tipe.equals("Member")) total *= 0.9;

            st.setString(1, tipe);
            st.setString(2, snack);
            st.setInt(3, jumlah);
            st.setDouble(4, harga);
            st.setString(5, promo ? "Ya" : "Tidak");
            st.setDouble(6, total);
            st.setString(7, nama);

            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            tampilData();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal mengubah data: " + e.getMessage());
        }
    }

    private void hapusData() {
        try (Connection conn = Koneksi.getKoneksi()) {
            String sql = "DELETE FROM tb_snackstore WHERE nama_pembeli=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, txtNama.getText());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            tampilData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage());
        }
    }

    private void cariData() {
        try (Connection conn = Koneksi.getKoneksi()) {
            String sql = "SELECT * FROM tb_snackstore WHERE nama_pembeli=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, txtNama.getText());
            ResultSet rs = st.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Nama");
            model.addColumn("Tipe Pembeli");
            model.addColumn("Snack");
            model.addColumn("Jumlah");
            model.addColumn("Harga");
            model.addColumn("Promo");
            model.addColumn("Total Bayar");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("nama_pembeli"),
                    rs.getString("tipe_pembeli"),
                    rs.getString("snack"),
                    rs.getInt("jumlah"),
                    rs.getDouble("harga"),
                    rs.getString("promo"),
                    rs.getDouble("total_bayar")
                });
            }
            tabel.setModel(model);


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal mencari data: " + e.getMessage());
        }
    }

    private double getHargaSnack(String snack) {
        return switch (snack) {
            case "Choco Crunch" -> 8000;
            case "Matcha Wafer" -> 9500;
            case "Nori Stick" -> 11000;
            case "Pocky Strawberry" -> 10500;
            case "Kinder Bueno" -> 12000;
            case "Cheese Stick" -> 6000;
            case "Taro Chips" -> 5500;
            case "Singkong Crispy" -> 5000;
            case "Keripik Tempe" -> 6500;
            case "Keripik Pisang" -> 7000;
            default -> 6000;
        };
    }
    




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbMember = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        cbPromo = new javax.swing.JCheckBox();
        cmbSnack = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        statusBar = new javax.swing.JLabel();
        cmbKategori = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        rbUmum = new javax.swing.JRadioButton();
        txtNama = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        txtJumlah = new javax.swing.JTextField();
        txtTambah = new javax.swing.JButton();
        txtUbah = new javax.swing.JButton();
        txtHapus = new javax.swing.JButton();
        txtCari = new javax.swing.JButton();
        txtRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rbMember.setText("Member");

        jLabel8.setText("Pilih Snack  :");

        cbPromo.setText("Promo Diskon 20 %");
        cbPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPromoActionPerformed(evt);
            }
        });

        cmbSnack.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choco Crunch", "Matcha Wafer", "Nori Stick", "Pocky Strawberry", "Kinder Bueno", "Chesee Stick", "Taro Chips", "Singkong Crispy", "Kripik Tempe", "Kripik Pisang" }));
        cmbSnack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSnackActionPerformed(evt);
            }
        });

        jLabel4.setText("Jumlah        :");

        jLabel2.setText("Kategori      :");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Selamat Datang di Snack Store");

        jLabel3.setText("Tipe Pembeli :");

        statusBar.setText("Status Bar");

        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Snack Import", "Snack Lokal" }));
        cmbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKategoriActionPerformed(evt);
            }
        });

        jLabel6.setText("Nama          :");

        rbUmum.setText("Umum");
        rbUmum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbUmumActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nama", "Tipe Pembeli", "Snack", "Jumlah", "Harga", "Promo", "Total Bayar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabel);

        txtTambah.setText("Tambah");
        txtTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTambahActionPerformed(evt);
            }
        });

        txtUbah.setText("Ubah");
        txtUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUbahActionPerformed(evt);
            }
        });

        txtHapus.setText("Hapus");
        txtHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHapusActionPerformed(evt);
            }
        });

        txtCari.setText("Cari");
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });

        txtRefresh.setText("Refresh");
        txtRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNama)
                                    .addComponent(cmbKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbSnack, 0, 280, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbUmum)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbMember))
                                .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(statusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRefresh)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmbSnack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(rbUmum)
                            .addComponent(rbMember))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPromo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTambah)
                            .addComponent(txtUbah)
                            .addComponent(txtHapus)
                            .addComponent(txtCari)
                            .addComponent(txtRefresh))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(statusBar)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPromoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPromoActionPerformed

    private void cmbSnackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSnackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSnackActionPerformed

    private void cmbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKategoriActionPerformed

    private void rbUmumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbUmumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbUmumActionPerformed

    private void txtTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTambahActionPerformed
        // TODO add your handling code here:
        tambahData();
    }//GEN-LAST:event_txtTambahActionPerformed

    private void txtUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUbahActionPerformed
        // TODO add your handling code here:
        ubahData();
    }//GEN-LAST:event_txtUbahActionPerformed

    private void txtHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHapusActionPerformed
        // TODO add your handling code here:
        hapusData();
    }//GEN-LAST:event_txtHapusActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
        cariData();
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRefreshActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtRefreshActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUISnackStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUISnackStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUISnackStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUISnackStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUISnackStore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbPromo;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JComboBox<String> cmbSnack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbMember;
    private javax.swing.JRadioButton rbUmum;
    private javax.swing.JLabel statusBar;
    private javax.swing.JTable tabel;
    private javax.swing.JButton txtCari;
    private javax.swing.JButton txtHapus;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtNama;
    private javax.swing.JButton txtRefresh;
    private javax.swing.JButton txtTambah;
    private javax.swing.JButton txtUbah;
    // End of variables declaration//GEN-END:variables
}
