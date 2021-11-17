/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Models.BusCTSanPhamModel;
import GUI.Models.CartModel;
import static GUI.QuanlyGiaoDichJFrame.cartModel;
import GUI.Services.ButtonColumn;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QLImei extends javax.swing.JFrame {
    Icon iconXoa = new ImageIcon(getClass().getResource("/icon/Delete.png"));
    /**
     * Creates new form QLImei
     */
    CartModel cart = new CartModel();
    int index;
    int indexsp;
    BusCTSanPhamModel busCTSanPhamModel;
    public QLImei(CartModel cart, int index) {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.cart = cart;
        busCTSanPhamModel = QuanlyGiaoDichJFrame.listSp.stream().filter(sp -> sp.getMaCTSP()== cart.getMactsp()).toList().get(0);
        indexsp = QuanlyGiaoDichJFrame.listSp.indexOf(busCTSanPhamModel);
        this.index = index;
        buttonRemove();
        fillTable();
    }
    DefaultTableModel model;
    void fillTable() {
        model = (DefaultTableModel) tblImei.getModel();
        model.setRowCount(0);
        cart.getListImeis().forEach(imei -> {
            model.addRow(new Object[] {
                imei,
                iconXoa
            });
        });
    }
    private void buttonRemove() {
        Action remove = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int row: tblImei.getSelectedRows()) {
                    int tonKho = busCTSanPhamModel.getTonKho() + 1;
                    busCTSanPhamModel.setTonKho(tonKho);
                    cart.getListImeis().remove(row);
                    fillTable();
                }
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(tblImei, remove, 1);

        buttonColumn.setMnemonic(KeyEvent.VK_D);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblImei = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tblImei.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Imei", "Xóa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblImei.setRowHeight(60);
        jScrollPane1.setViewportView(tblImei);
        if (tblImei.getColumnModel().getColumnCount() > 0) {
            tblImei.getColumnModel().getColumn(1).setMinWidth(70);
            tblImei.getColumnModel().getColumn(1).setMaxWidth(70);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        QuanlyGiaoDichJFrame.listCart.set(index, cart);
        QuanlyGiaoDichJFrame.listSp.set(indexsp, busCTSanPhamModel);
        QuanlyGiaoDichJFrame.fillTable(QuanlyGiaoDichJFrame.listSp);
        QuanlyGiaoDichJFrame.fillToCart(QuanlyGiaoDichJFrame.cartModel, QuanlyGiaoDichJFrame.tblCart);
    }//GEN-LAST:event_formWindowClosed

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(QLImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(QLImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(QLImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(QLImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new QLImei().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblImei;
    // End of variables declaration//GEN-END:variables
}
