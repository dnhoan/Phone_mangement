/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Models.BusCTSanPhamModel;
import BUS.Services.BusImeiService;
import GUI.Models.CartModel;
import static GUI.QLImei.tblImei;
import GUI.Services.ButtonColumn;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class RemoveImeiHoaDon extends javax.swing.JFrame {
    CartModel cart = new CartModel();
    int index;
    int indexsp;
    BusCTSanPhamModel busCTSanPhamModel;
    Icon iconXoa = new ImageIcon(getClass().getResource("/icon/Delete.png"));
    /**
     * Creates new form RemoveImeiHoaDon
     */
    public RemoveImeiHoaDon() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
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
                "Mã Imei", "Tên Imei", "Xóa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblImei.setRowHeight(30);
        jScrollPane1.setViewportView(tblImei);
        if (tblImei.getColumnModel().getColumnCount() > 0) {
            tblImei.getColumnModel().getColumn(0).setMinWidth(0);
            tblImei.getColumnModel().getColumn(0).setMaxWidth(0);
            tblImei.getColumnModel().getColumn(2).setMinWidth(50);
            tblImei.getColumnModel().getColumn(2).setMaxWidth(50);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        QuanLyBanHang.listCart.set(index, cart);
        QuanLyBanHang.listSp.set(indexsp, busCTSanPhamModel);
        QuanLyBanHang.fillTable(QuanLyBanHang.listSp);
        QuanLyBanHang.fillToCart(QuanLyBanHang.cartModel, QuanLyBanHang.tblCart);
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(RemoveImeiHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RemoveImeiHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RemoveImeiHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RemoveImeiHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RemoveImeiHoaDon().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblImei;
    // End of variables declaration//GEN-END:variables

    public RemoveImeiHoaDon(CartModel cart, int index) {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.cart = cart;
        busCTSanPhamModel = QuanLyBanHang.listSp.stream().filter(sp -> sp.getMaCTSP()== cart.getMactsp()).toList().get(0);
        indexsp = QuanLyBanHang.listSp.indexOf(busCTSanPhamModel);
        this.index = index;
        btnRemoveCart();
        fillTable();
        isGiaoDich = true;
    }
    DefaultTableModel model;
    boolean isGiaoDich = false;
    void fillTable() {
        model = (DefaultTableModel) tblImei.getModel();
        model.setRowCount(0);
        cart.getListImeis().forEach(imei -> {
            model.addRow(new Object[] {
                imei.getMaImei(),
                imei.getTenImei(),
                iconXoa
            });
        });
    }
    private void btnRemoveCart() {
        Action remove = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int row: tblImei.getSelectedRows()) {
                    int tonKho = busCTSanPhamModel.getTonKho() + 1;
                    busCTSanPhamModel.setTonKho(tonKho);
//                    BusImeiService.updateStatusSell((Integer) tblImei.getValueAt(row, 0), 1);
                    cart.getListImeis().remove(row);
                    fillTable();
                }
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(tblImei, remove, 2);

        buttonColumn.setMnemonic(KeyEvent.VK_D);
    }
}
