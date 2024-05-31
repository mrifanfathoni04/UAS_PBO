/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.UserSession;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Database;
import static model.Database.rs;
import model.Pakaian;

/**
 *
 * @author MSI Modern 14
 */
public class BeliPakaian extends javax.swing.JFrame {

    /**
     * Creates new form BeliPakaian
     */
    public BeliPakaian() {
        initComponents();
        table();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    public void table() {
        Database.connect();
        try {
            String query = "SELECT * FROM pakaian where status=''";
            Database.pst = Database.conn.prepareStatement(query);
            Database.rs = Database.pst.executeQuery();
            DefaultTableModel table = (DefaultTableModel) tabelPakaian.getModel();
            table.setRowCount(0);
            
            while (rs.next()) {
                Vector baris = new Vector();
                baris.add(rs.getString("id"));
                baris.add(rs.getString("jenis"));
                baris.add(rs.getString("model"));
                baris.add(rs.getString("desain"));
                baris.add(rs.getString("bahan"));
                baris.add(rs.getString("warna"));
                baris.add(rs.getString("ukuran"));
                baris.add(rs.getString("harga"));
                table.addRow(baris);
                
            }
        } catch (SQLException e) {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPakaian = new javax.swing.JTable();
        btnKembali = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        btnBeli = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        tabelPakaian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pakaian", "Jenis", "Model", "Desain", "Bahan", "Warna", "Ukuran", "Harga"
            }
        ));
        tabelPakaian.setMaximumSize(null);
        tabelPakaian.setMinimumSize(null);
        tabelPakaian.setPreferredSize(null);
        tabelPakaian.setShowGrid(false);
        jScrollPane1.setViewportView(tabelPakaian);

        btnKembali.setBackground(new java.awt.Color(153, 255, 255));
        btnKembali.setFont(new java.awt.Font("Buxton Sketch", 0, 24)); // NOI18N
        btnKembali.setForeground(new java.awt.Color(255, 204, 102));
        btnKembali.setText("Kembali Ke Menu Sebelumnya");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Buxton Sketch", 3, 48)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 204, 102));
        jLabel31.setText("MENU CUSTOMER - BELI PAKAIAN");
        jLabel31.setPreferredSize(new java.awt.Dimension(532, 60));

        btnBeli.setBackground(new java.awt.Color(153, 255, 255));
        btnBeli.setFont(new java.awt.Font("Buxton Sketch", 0, 36)); // NOI18N
        btnBeli.setForeground(new java.awt.Color(255, 204, 102));
        btnBeli.setText("Beli Pakaian");
        btnBeli.setActionCommand("History Pembelian");
        btnBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBeliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKembali))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKembali)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBeliActionPerformed
        // TODO add your handling code here:
        int row = tabelPakaian.getSelectedRow();
        if (row >= 0) {
            DefaultTableModel model = (DefaultTableModel) tabelPakaian.getModel();
                String id = model.getValueAt(row, 0).toString();
                String harga = model.getValueAt(row, 7).toString();
            int response = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Membeli data Pakaian id "+id+" dengan harga "+harga+" ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                Pakaian.BeliPakainan(id,UserSession.getInstance().getUserName());
                table();
                 JOptionPane.showMessageDialog(null, "Pembelian Pakaian Berhasil");
            }else{JOptionPane.showMessageDialog(null, "Pembelian Pakaian Dibatalkan");}
        } else {
            JOptionPane.showMessageDialog(null, "Tidak ada baris pada tabel yang dipilih! ");
        }
    }//GEN-LAST:event_btnBeliActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
        MenuCustomer dashboardCustomer = new MenuCustomer();
        this.setVisible(false);
        dashboardCustomer.setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed

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
            java.util.logging.Logger.getLogger(BeliPakaian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BeliPakaian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BeliPakaian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BeliPakaian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BeliPakaian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBeli;
    private javax.swing.JButton btnKembali;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelPakaian;
    // End of variables declaration//GEN-END:variables
}
