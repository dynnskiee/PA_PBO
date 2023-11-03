/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import controller.controller_pemesanan;

/**
 *
 * @author NITRO 5
 */
public class karyawan extends javax.swing.JFrame {

    controller_pemesanan Controller_Pemesanan;
    public karyawan() {
        initComponents();
        Controller_Pemesanan = new controller_pemesanan(this);
        Controller_Pemesanan.isiTable();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIDPemesanan = new javax.swing.JTextField();
        txtJumlahTiket = new javax.swing.JTextField();
        txtTotalHarga = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCariData = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelDataPemesanan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("PEMESANAN");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(250, 30, 160, 30);

        jLabel2.setText("ID PEMESANAN");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 90, 90, 20);

        jLabel3.setText("JUMLAH TIKET");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(110, 130, 108, 16);

        jLabel4.setText("TOTAL HARGA");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(110, 170, 85, 16);

        txtIDPemesanan.setEditable(false);
        getContentPane().add(txtIDPemesanan);
        txtIDPemesanan.setBounds(250, 90, 310, 22);

        txtJumlahTiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahTiketActionPerformed(evt);
            }
        });
        getContentPane().add(txtJumlahTiket);
        txtJumlahTiket.setBounds(250, 130, 310, 22);
        getContentPane().add(txtTotalHarga);
        txtTotalHarga.setBounds(250, 170, 310, 22);

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan);
        btnSimpan.setBounds(250, 220, 73, 23);

        btnUbah.setText("UBAH");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        getContentPane().add(btnUbah);
        btnUbah.setBounds(330, 220, 72, 23);

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus);
        btnHapus.setBounds(410, 220, 72, 23);

        btnBatal.setText("BATAL");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        getContentPane().add(btnBatal);
        btnBatal.setBounds(490, 220, 72, 23);

        jLabel7.setText("Cari Data :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(110, 290, 60, 16);
        getContentPane().add(txtCariData);
        txtCariData.setBounds(170, 290, 230, 20);

        btnCari.setText("CARI");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });
        getContentPane().add(btnCari);
        btnCari.setBounds(410, 290, 60, 20);

        btnRefresh.setText("REFRESH");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(btnRefresh);
        btnRefresh.setBounds(480, 290, 80, 20);

        TabelDataPemesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID PEMESANAN", "JUMLAH TIKET", "TOTAL HARGA"
            }
        ));
        TabelDataPemesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelDataPemesananMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabelDataPemesanan);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(110, 330, 452, 160);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        Controller_Pemesanan.insert();
        Controller_Pemesanan.isiTable();
        Controller_Pemesanan.reset();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        Controller_Pemesanan.update();
        Controller_Pemesanan.isiTable();
        Controller_Pemesanan.reset();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        Controller_Pemesanan.delete();
        Controller_Pemesanan.isiTable();
        Controller_Pemesanan.reset();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        Controller_Pemesanan.reset();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        Controller_Pemesanan.carinama();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        Controller_Pemesanan.isiTable();
        Controller_Pemesanan.reset();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void TabelDataPemesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelDataPemesananMouseClicked
        Controller_Pemesanan.isiField(TabelDataPemesanan.getSelectedRow());
    }//GEN-LAST:event_TabelDataPemesananMouseClicked

    private void txtJumlahTiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahTiketActionPerformed
        
    }//GEN-LAST:event_txtJumlahTiketActionPerformed

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
            java.util.logging.Logger.getLogger(karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new karyawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelDataPemesanan;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtCariData;
    private javax.swing.JTextField txtIDPemesanan;
    private javax.swing.JTextField txtJumlahTiket;
    private javax.swing.JTextField txtTotalHarga;
    // End of variables declaration//GEN-END:variables

    public JTable getTabelDataPemesanan() {
        return TabelDataPemesanan;
    }

    public JButton getBtnBatal() {
        return btnBatal;
    }

    public JButton getBtnCari() {
        return btnCari;
    }

    public JButton getBtnHapus() {
        return btnHapus;
    }

    public JButton getBtnRefresh() {
        return btnRefresh;
    }

    public JButton getBtnSimpan() {
        return btnSimpan;
    }

    public JButton getBtnUbah() {
        return btnUbah;
    }

    public JTextField getTxtCariData() {
        return txtCariData;
    }

    public JTextField getTxtIDPemesanan() {
        return txtIDPemesanan;
    }

    public JTextField getTxtJumlahTiket() {
        return txtJumlahTiket;
    }

    public JTextField getTxtTotalHarga() {
        return txtTotalHarga;
    }
}

